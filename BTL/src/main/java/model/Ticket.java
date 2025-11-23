package model;

public class Ticket {
    private String id;
    private String flightId;
    private String seatId;
    private String customerId;
    private double price;
    private String status; // BOOKED, CANCELLED

    public Ticket(String id, String flightId, String seatId, String customerId, double price, String status) {
        this.id = id;
        this.flightId = flightId;
        this.seatId = seatId;
        this.customerId = customerId;
        this.price = price;
        this.status = status;
    }

    // Getters
    public String getId() { return id; }
    public String getFlightId() { return flightId; }
    public String getSeatId() { return seatId; }
    public String getCustomerId() { return customerId; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String toCsv() {
        return String.join(",",
                id,
                flightId,
                seatId,
                customerId,
                String.format("%.0f", price), // Định dạng số không có .0
                status
        );
    }

    @Override
    public String toString() {
        return String.format("Ticket[%s]: Flight %s | Seat %s | Price %,.0f | %s",
                id, flightId, seatId, price, status);
    }
}