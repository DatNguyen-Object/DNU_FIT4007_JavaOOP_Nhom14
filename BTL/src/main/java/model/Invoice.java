package model;

import common.DateUtils;
import java.time.LocalDateTime;

public class Invoice {
    private String id;
    private String ticketId;
    private double amount;
    private LocalDateTime paymentTime;
    private String paymentMethod; // CASH, BANKING, CREDIT_CARD

    public Invoice(String id, String ticketId, double amount, LocalDateTime paymentTime, String paymentMethod) {
        this.id = id;
        this.ticketId = ticketId;
        this.amount = amount;
        this.paymentTime = paymentTime;
        this.paymentMethod = paymentMethod;
    }

    public String getId() { return id; }
    public String getTicketId() { return ticketId; }
    public double getAmount() { return amount; }
    public LocalDateTime getPaymentTime() { return paymentTime; }
    public String getPaymentMethod() { return paymentMethod; }

    public String toCsv() {
        return String.join(",",
                id,
                ticketId,
                String.valueOf(amount),
                DateUtils.toString(paymentTime),
                paymentMethod
        );
    }

    @Override
    public String toString() {
        return String.format("Invoice[%s]: %s - %,.0f VND (%s)", id, ticketId, amount, paymentMethod);
    }
}