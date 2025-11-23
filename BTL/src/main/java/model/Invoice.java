package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Invoice {
    private String id;
    private String ticketId;
    private double amount;
    private LocalDateTime paymentTime;
    private String paymentMethod;

    // Định dạng ngày giờ riêng
    public static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Invoice(String id, String ticketId, double amount, LocalDateTime paymentTime, String paymentMethod) {
        this.id = id;
        this.ticketId = ticketId;
        this.amount = amount;
        this.paymentTime = paymentTime;
        this.paymentMethod = paymentMethod;
    }

    public String getId() { return id; }

    public String toCsv() {
        return String.join(",",
                id,
                ticketId,
                String.format("%.0f", amount),
                paymentTime.format(FMT), // Tự format tại đây
                paymentMethod
        );
    }
}