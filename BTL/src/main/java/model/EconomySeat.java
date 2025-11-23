package model;

public class EconomySeat extends Seat {
    public EconomySeat(String id, boolean isBooked) {
        super(id, isBooked);
    }

    @Override
    public double getSurcharge() {
        return 0;
    }
}