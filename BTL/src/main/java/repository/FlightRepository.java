package repository;
import model.Flight;
import java.time.LocalDateTime;
import java.util.List;

public class FlightRepository extends CsvRepository<Flight> {

    public FlightRepository() {
        // 👇 DÁN ĐƯỜNG DẪN CỦA BẠN VÀO ĐÂY (Nhớ dùng 2 dấu gạch chéo \\)
        super("C:\\Users\\Admin\\IdeaProjects\\DNU_FIT4007_JavaOOP_Nhom14\\BTL\\src\\main\\resources\\data\\flights.csv");
    }

    // ... (Các phần dưới giữ nguyên không đổi)
    @Override protected Flight fromCsv(String line) {
        try {
            String[] d = line.split(",");
            if (d.length < 4) return null;
            return new Flight(d[0], d[1], LocalDateTime.parse(d[2], Flight.FMT), Double.parseDouble(d[3]));
        } catch (Exception e) { return null; }
    }
    @Override protected String toCsv(Flight f) {
        return String.join(",", f.getId(), f.getRoute(), f.getTimeStr(), String.format("%.0f", f.getBasePrice()));
    }
    @Override public void update(Flight item) {}
    public Flight findById(String id) {
        if(items == null) return null;
        return items.stream().filter(f -> f.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}