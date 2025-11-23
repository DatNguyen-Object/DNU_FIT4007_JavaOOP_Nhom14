package service;

import model.*;
import repository.*;
import exception.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class BookingService implements RefundPolicy {
    private FlightRepository flightRepo;
    private TicketRepository ticketRepo;
    private CustomerRepository custRepo;

    public BookingService(FlightRepository fr, TicketRepository tr, CustomerRepository cr) {
        this.flightRepo = fr;
        this.ticketRepo = tr;
        this.custRepo = cr;
    }

    public void loadBookedSeats() {
        for (Ticket t : ticketRepo.getAll()) {
            if ("BOOKED".equals(t.getStatus())) {
                Flight f = flightRepo.findById(t.getFlightId());
                if (f != null) {
                    f.getSeats().stream()
                            .filter(s -> s.getId().equals(t.getSeatId()))
                            .forEach(s -> s.setBooked(true));
                }
            }
        }
    }

    public double bookTicket(String fid, String sid, String cid) throws Exception {
        loadBookedSeats();
        Flight f = flightRepo.findById(fid);

        if (f == null) throw new FlightNotFoundException("Mã chuyến bay sai: " + fid);

        // 👇 SỬA: Dùng Exception thường (vì đã xóa CustomerNotFoundException)
        if (custRepo.findById(cid) == null) {
            throw new Exception("Khách hàng mã " + cid + " không tồn tại!");
        }

        Seat s = f.getSeats().stream()
                .filter(seat -> seat.getId().equalsIgnoreCase(sid))
                .findFirst()
                .orElseThrow(() -> new Exception("Mã ghế sai: " + sid));

        if (s.isBooked()) throw new SeatAlreadyBookedException("Ghế " + sid + " đã có người đặt.");

        double price = f.getBasePrice() + s.getSurcharge();
        Ticket t = new Ticket(UUID.randomUUID().toString().substring(0,8), fid, sid, cid, price, "BOOKED");
        ticketRepo.add(t);
        s.setBooked(true);
        return price;
    }

    public double cancelTicket(String tid) throws Exception {
        Ticket t = ticketRepo.findById(tid);
        if (t == null) throw new Exception("Vé không tồn tại");
        if ("CANCELLED".equals(t.getStatus())) throw new Exception("Vé đã hủy rồi");

        Flight f = flightRepo.findById(t.getFlightId());
        long hours = ChronoUnit.HOURS.between(LocalDateTime.now(), f.getDepartureTime());

        if (hours < 0) throw new InvalidCancellationException("Máy bay đã cất cánh.");

        double refund = calculateRefund(t.getPrice(), hours);
        t.setStatus("CANCELLED");
        ticketRepo.update(t);
        return refund;
    }

    @Override
    public double calculateRefund(double price, long hours) {
        if (hours >= 48) return price * 0.9;
        if (hours > 0) return price * 0.5;
        return 0;
    }
}