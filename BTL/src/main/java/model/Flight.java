package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String id;
    private String route;
    private LocalDateTime departureTime;
    private double basePrice;
    private List<Seat> seats;

    public Flight(String id, String route, LocalDateTime departureTime, double basePrice) {
        this.id = id;
        this.route = route;
        this.departureTime = departureTime;
        this.basePrice = basePrice;
        this.seats = new ArrayList<>();
        initSeats(); // Tự động tạo ghế ngay khi tạo chuyến bay
    }

    private void initSeats() {
        // 2 Ghế Thương gia đầu tiên
        seats.add(new BusinessSeat("B1", false));
        seats.add(new BusinessSeat("B2", false));

        // 10 Ghế Phổ thông tiếp theo
        for (int i = 1; i <= 10; i++) {
            seats.add(new EconomySeat("E" + i, false));
        }
    }

    // Getters (Encapsulation)
    public String getId() { return id; }
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public double getBasePrice() { return basePrice; }
    public List<Seat> getSeats() { return seats; }
}