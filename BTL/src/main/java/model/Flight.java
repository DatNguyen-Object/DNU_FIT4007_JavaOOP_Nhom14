package model;
import java.util.List;

public class Flight {
    public String id;
    public String route;
    public String date; // Dùng String là kém chuyên nghiệp (khó tính toán giờ)
    public double price;
    public List<Seat> seats;

    public Flight(String id, String route, String date, double price) {
        this.id = id;
        this.route = route;
        this.date = date;
        this.price = price;
    }
}