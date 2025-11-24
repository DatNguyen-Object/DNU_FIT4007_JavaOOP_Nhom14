package repository;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class SeatRepository extends CsvRepository<Seat> {
    public SeatRepository() {
        super("src/main/resources/data/seats.csv");
    }

    @Override
    protected Seat fromCsv(String line) {
        String[] d = line.split(",");
        String id = d[0];
        String fid = d[1];
        String num = d[2];
        String type = d[3];
        boolean booked = Boolean.parseBoolean(d[4]);

        if (type.equals("BUSINESS")) {
            return new BusinessSeat(id, fid, num, booked);
        }
        if (type.equals("FIRST_CLASS")) {
            return new FirstClassSeat(id, fid, num, booked);
        }
        return new EconomySeat(id, fid, num, booked);
    }

    @Override
    protected String toCsv(Seat s) {
        return s.toCsv();
    }

    @Override
    public void update(Seat item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(item.getId())) {
                items.set(i, item);
                saveToFile();
                return;
            }
        }
    }

    public Seat findById(String id) {
        for (Seat s : items) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
    }

    public Seat findByFlightAndNumber(String fid, String num) {
        for (Seat s : items) {
            if (s.getFlightId().equalsIgnoreCase(fid) && s.getSeatNumber().equalsIgnoreCase(num)) {
                return s;
            }
        }
        return null;
    }

    public List<Seat> getByFlightId(String fid) {
        List<Seat> list = new ArrayList<>();
        for (Seat s : items) {
            if (s.getFlightId().equals(fid)) {
                list.add(s);
            }
        }
        return list;
    }

    public void generateSeats(String flightId) {
        for (int i = 1; i <= 2; i++) {
            add(new FirstClassSeat(flightId + "_F" + i, flightId, "F" + i, false));
        }
        for (int i = 1; i <= 4; i++) {
            add(new BusinessSeat(flightId + "_B" + i, flightId, "B" + i, false));
        }
        for (int i = 1; i <= 10; i++) {
            add(new EconomySeat(flightId + "_E" + i, flightId, "E" + i, false));
        }
    }
}