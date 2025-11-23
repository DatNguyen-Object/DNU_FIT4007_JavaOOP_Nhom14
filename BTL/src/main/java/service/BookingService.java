package service;

import model.*;
import repository.*;
import exception.*;
import java.util.UUID;

public class BookingService implements RefundPolicy {
    private FlightRepository flightRepo;
    private TicketRepository ticketRepo;

    public BookingService(FlightRepository flightRepo, TicketRepository ticketRepo) {
        this.flightRepo = flightRepo;
        this.ticketRepo = ticketRepo;
    }

    public double bookTicket(String flightId, String seatId, String custId) throws Exception {
        Flight f = flightRepo.findById(flightId);
        if (f == null) throw new FlightNotFoundException("Mã chuyến bay không tồn tại: " + flightId);

        // Dùng Stream API tìm ghế cực gọn
        Seat s = f.getSeats().stream()
                .filter(seat -> seat.getId().equalsIgnoreCase(seatId))
                .findFirst()
                .orElseThrow(() -> new Exception("Không tìm thấy ghế: " + seatId));

        if (s.isBooked()) throw new SeatAlreadyBookedException("Ghế " + seatId + " đã có người đặt.");

        // Cập nhật trạng thái
        s.setBooked(true);
        flightRepo.update(f);

        double price = f.getBasePrice() + s.getSurcharge();
        // Tạo vé và lưu
        Ticket t = new Ticket(UUID.randomUUID().toString(), flightId, seatId, custId, price, "BOOKED");
        ticketRepo.add(t);

        return price;
    }

    @Override
    public double calculateRefund(double price, long hours) {
        if (hours >= 48) return price * 0.9; // Hoàn 90%
        if (hours > 0) return price * 0.5;   // Hoàn 50%
        return 0;
    }
}