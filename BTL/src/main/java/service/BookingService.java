package service;

import model.*;
import repository.*;
import exception.*;
import common.DateUtils;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BookingService implements RefundPolicy {
    private FlightRepository fRepo;
    private SeatRepository sRepo;
    private TicketRepository tRepo;
    private CustomerRepository cRepo;
    private InvoiceRepository iRepo;

    public BookingService(FlightRepository f, SeatRepository s, TicketRepository t, CustomerRepository c, InvoiceRepository i) {
        this.fRepo = f;
        this.sRepo = s;
        this.tRepo = t;
        this.cRepo = c;
        this.iRepo = i;
    }

    public void loadSeatsForFlight(Flight f) {
        f.setSeats(sRepo.getByFlightId(f.getId()));
    }

    public double bookTicket(String fid, String sid, String cid) throws Exception {
        Flight f = fRepo.findById(fid);
        if (f == null) {
            throw new FlightNotFoundException("Không tìm thấy chuyến bay");
        }
        if (cRepo.findById(cid) == null) {
            throw new CustomerNotFoundException("Khách hàng không tồn tại");
        }

        Seat s = sRepo.findByFlightAndNumber(fid, sid);
        if (s == null) {
            throw new Exception("Ghế không tồn tại");
        }
        if (s.isBooked()) {
            throw new SeatAlreadyBookedException("Ghế đã đặt");
        }

        double total = f.getBasePrice() + s.getSurcharge();

        s.setBooked(true);
        sRepo.update(s);

        String tid = "T-" + System.currentTimeMillis();
        Ticket t = new Ticket(tid, fid, s.getId(), cid, total, "BOOKED");
        tRepo.add(t);

        Invoice inv = new Invoice("INV-" + tid, tid, total, LocalDateTime.now());
        iRepo.add(inv);

        return total;
    }

    public double cancelTicket(String tid) throws Exception {
        Ticket t = tRepo.findById(tid);
        if (t == null) {
            throw new Exception("Vé không tồn tại");
        }
        if (t.getStatus().equals("CANCELLED")) {
            throw new Exception("Vé đã hủy");
        }

        Flight f = fRepo.findById(t.getFlightId());
        long hours = ChronoUnit.HOURS.between(LocalDateTime.now(), f.getDepartureTime());

        if (hours < 0) {
            throw new InvalidCancellationException("Đã bay, không thể hủy");
        }

        double refund = calculateRefund(t.getPrice(), hours);
        t.setStatus("CANCELLED");
        tRepo.update(t);

        Seat s = sRepo.findById(t.getSeatId());
        if (s != null) {
            s.setBooked(false);
            sRepo.update(s);
        }
        return refund;
    }

    public void suggestFlights(String dateStr, String dest) {
        System.out.println("--- GỢI Ý CHUYẾN BAY ---");
        boolean found = false;
        for (Flight f : fRepo.getAll()) {
            String fDate = common.DateUtils.toString(f.getDepartureTime());
            if (fDate.startsWith(dateStr) && f.getRoute().endsWith(dest)) {
                long emptySeats = sRepo.getByFlightId(f.getId()).stream().filter(s -> !s.isBooked()).count();
                if (emptySeats > 0) {
                    System.out.printf("Chuyến %s | Giờ: %s | Giá: %.0f | Còn %d ghế\n", f.getId(), fDate, f.getBasePrice(), emptySeats);
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy chuyến bay phù hợp!");
        }
    }

    @Override
    public double calculateRefund(double price, long hours) {
        if (hours >= 48) return price * 0.9;
        if (hours > 0) return price * 0.5;
        return 0;
    }
}