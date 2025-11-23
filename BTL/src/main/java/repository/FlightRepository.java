package repository;
import model.Flight;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private List<Flight> flights = new ArrayList<>();

    public FlightRepository() {
        // FAKE DATA: Chưa đọc file, tạo tay để test logic
        flights.add(new Flight("VN101", "HAN-SGN", LocalDateTime.now(), 1500000));
        flights.add(new Flight("VJ202", "HAN-DAD", LocalDateTime.now(), 800000));
    }

    public List<Flight> getAll() { return flights; }

    public Flight findById(String id) {
        for (Flight f : flights) {
            if (f.getId().equalsIgnoreCase(id)) return f;
        }
        return null;
    }
}