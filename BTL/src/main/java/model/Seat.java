package model;

public abstract class Seat {
    public String id;
    public boolean isBooked;

    public Seat(String id) {
        this.id = id;
    }
}