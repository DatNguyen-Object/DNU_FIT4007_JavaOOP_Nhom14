package model;

public abstract class Seat {
    protected String id;
    protected String flightId;
    protected String seatNumber;
    protected boolean isBooked;

    public Seat(String id, String flightId, String seatNumber, boolean isBooked) {
        this.id = id;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.isBooked = isBooked;
    }

    public abstract double getSurcharge();

    public abstract String getType();

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

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String toCsv() {
        return id + "," + flightId + "," + seatNumber + "," + getType() + "," + isBooked;
    }

    @Override
    public String toString() {
        return seatNumber + (isBooked ? "[X]" : "[_]");
    }
}