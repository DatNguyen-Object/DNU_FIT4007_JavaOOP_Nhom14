package repository;
import model.Flight;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    public FlightRepository() {
        flights.add(new Flight("VN001", "HAN-SGN", LocalDateTime.now().plusDays(1), 1500000));
        flights.add(new Flight("VJ202", "HAN-DAD", LocalDateTime.now().plusDays(2), 800000));
    }

    public List<Flight> getAll() { return flights; }
}
