package model;

import common.DateUtils;
import java.time.LocalDateTime;

public class Invoice {
    private String id;
    private String ticketId;
    private double amount;
    private LocalDateTime createdDate;

    public Invoice(String id, String ticketId, double amount, LocalDateTime createdDate) {
        this.id = id;
        this.ticketId = ticketId;
        this.amount = amount;
        this.createdDate = createdDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String toCsv() {
        return id + "," + ticketId + "," + amount + "," + DateUtils.toString(createdDate);
    }
}