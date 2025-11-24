package model;

public class FirstClassSeat extends Seat {
    public FirstClassSeat(String id, String flightId, String seatNumber, boolean isBooked) {
        super(id, flightId, seatNumber, isBooked);
    }

    @Override
    public double getSurcharge() {
        return 2000000;
    }

    @Override
    public String getType() {
        return "FIRST_CLASS";
    }
}