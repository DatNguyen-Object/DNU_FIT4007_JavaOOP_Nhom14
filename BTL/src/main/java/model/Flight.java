package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String id;
    private String route;
    private LocalDateTime departureTime;
    private double basePrice;
    private List<Seat> seats;

    // Định dạng ngày giờ dùng chung (Thay thế DateUtils)
    public static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Flight(String id, String route, LocalDateTime departureTime, double basePrice) {
        // 👇 QUAN TRỌNG: Đã thêm "this." để sửa lỗi null dữ liệu
        this.id = id;
        this.route = route;
        this.departureTime = departureTime;
        this.basePrice = basePrice;

        this.seats = new ArrayList<>();
        initSeats();
    }

    private void initSeats() {
        seats.add(new BusinessSeat("B1", false));
        seats.add(new BusinessSeat("B2", false));
        for (int i = 1; i <= 10; i++) {
            seats.add(new EconomySeat("E" + i, false));
        }
    }

    public String getId() { return id; }
    public String getRoute() { return route; }
    public LocalDateTime getDepartureTime() { return departureTime; }
    public double getBasePrice() { return basePrice; }
    public List<Seat> getSeats() { return seats; }

    // Helper để lấy chuỗi ngày tháng
    public String getTimeStr() {
        return departureTime.format(FMT);
    }
}