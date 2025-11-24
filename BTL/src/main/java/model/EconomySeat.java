package model;

public class EconomySeat extends Seat {
    public EconomySeat(String id, String flightId, String seatNumber, boolean isBooked) {
        super(id, flightId, seatNumber, isBooked);
    }

    @Override
    public double getSurcharge() {
        return 0;
    }

    @Override
    public String getType() {
        return "ECONOMY";
    }
}