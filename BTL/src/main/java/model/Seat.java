package model;

public abstract class Seat {
    public String id; // Public là không tốt (phá vỡ đóng gói)
    public boolean isBooked;

    public Seat(String id) {
        this.id = id;
    }
    // Chưa có hàm tính tiền đa hình
}