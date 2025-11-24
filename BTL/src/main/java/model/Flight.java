package model;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Flight {
    protected String id;
    protected String route;
    protected LocalDateTime departureTime;
    protected double basePrice;
    protected String planeId;
    protected List<Seat> seats;

    public Flight(String id, String route, LocalDateTime departureTime, double basePrice, String planeId) {
        this.id = id;
        this.route = route;
        this.departureTime = departureTime;
        this.basePrice = basePrice;
        this.planeId = planeId;
    }

    public abstract String getType();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}