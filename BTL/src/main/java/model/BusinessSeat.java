package model;

public class BusinessSeat extends Seat {
    public BusinessSeat(String id, boolean isBooked) {
        super(id, isBooked);
    }

    @Override
    public double getSurcharge() {
        return 500000;
    }
}