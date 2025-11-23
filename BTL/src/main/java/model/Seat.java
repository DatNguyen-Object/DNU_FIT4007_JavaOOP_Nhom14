package model;

public abstract class Seat {
    protected String id;
    protected boolean isBooked;

    public Seat(String id, boolean isBooked) {
        this.id = id;
        this.isBooked = isBooked;
    }

    public abstract double getSurcharge();

    public String getId() { return id; }
    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }

    @Override
    public String toString() {
        return id + (isBooked ? "[X]" : "[_]"); // Hiển thị trạng thái ghế
    }
}