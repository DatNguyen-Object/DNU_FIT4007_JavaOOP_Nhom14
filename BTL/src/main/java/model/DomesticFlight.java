package model;

import common.DateUtils;
import java.time.LocalDateTime;

public class DomesticFlight extends Flight {
    public DomesticFlight(String id, String route, LocalDateTime departureTime, double basePrice, String planeId) {
        super(id, route, departureTime, basePrice, planeId);
    }

    @Override
    public String getType() {
        return "DOMESTIC";
    }

    public String toCsv() {
        return id + "," + route + "," + DateUtils.toString(departureTime) + "," + basePrice + "," + planeId;
    }
}