package model;

public class Ticket {
    private String id;
    private String flightId;
    private String seatId;
    private String customerId;
    private double price;
    private String status; // Mới thêm trạng thái

    public Ticket(String id, String flightId, String seatId, String customerId, double price) {
        this.id = id;
        this.flightId = flightId;
        this.seatId = seatId;
        this.customerId = customerId;
        this.price = price;
        this.status = "BOOKED"; // Mặc định là đã đặt
    }

    public String getId() { return id; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}