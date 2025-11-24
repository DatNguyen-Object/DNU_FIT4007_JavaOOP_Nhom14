package model;

public class BusinessSeat extends Seat {
    public BusinessSeat(String id, String flightId, String seatNumber, boolean isBooked) {
        super(id, flightId, seatNumber, isBooked);
    }

    @Override
    public double getSurcharge() {
        return 500000;
    }

    @Override
    public String getType() {
        return "BUSINESS";
    }
}