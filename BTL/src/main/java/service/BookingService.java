package service;
import repository.FlightRepository;
import repository.TicketRepository;
import model.Flight;
import model.Seat;

public class BookingService {
    private FlightRepository flightRepo = new FlightRepository();
    private TicketRepository ticketRepo = new TicketRepository();

    public void bookTicket(String flightId, String seatId) {
        Flight f = flightRepo.findById(flightId);
        if (f != null) {
            for (Seat s : f.getSeats()) {
                if (s.getId().equals(seatId)) {
                    s.setBooked(true);
                    System.out.println("Booking success!");
                    return;
                }
            }
        }
        System.out.println("Error: Booking failed.");
    }
}