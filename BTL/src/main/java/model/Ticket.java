package model;

public class Ticket {
    private String id;
    private String flightId;
    private String seatId;
    private String customerId;
    private double price;
    private String status;

    public Ticket(String id, String flightId, String seatId, String customerId, double price, String status) {
        this.id = id;
        this.flightId = flightId;
        this.seatId = seatId;
        this.customerId = customerId;
        this.price = price;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String toCsv() {
        return id + "," + flightId + "," + seatId + "," + customerId + "," + price + "," + status;
    }
}