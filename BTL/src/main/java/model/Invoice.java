package model;

public class Invoice {
    public String id;
    public String ticketId;
    public double amount;

    // Constructor tạm
    public Invoice(String id, String ticketId, double amount) {
        this.id = id;
        this.ticketId = ticketId;
        this.amount = amount;
    }
}