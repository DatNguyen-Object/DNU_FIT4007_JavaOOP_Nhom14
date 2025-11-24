package repository;

import common.DateUtils;
import model.DomesticFlight;
import model.Flight;

public class FlightRepository extends CsvRepository<Flight> {
    public FlightRepository() {
        super("src/main/resources/data/flights.csv");
    }

    @Override
    protected Flight fromCsv(String line) {
        String[] d = line.split(",");
        String pid = "UNKNOWN";
        if (d.length > 4) {
            pid = d[4];
        }
        return new DomesticFlight(d[0], d[1], DateUtils.fromString(d[2]), Double.parseDouble(d[3]), pid);
    }

    @Override
    protected String toCsv(Flight f) {
        if (f instanceof DomesticFlight) {
            return ((DomesticFlight) f).toCsv();
        }
        return "";
    }

    @Override
    public void update(Flight item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equalsIgnoreCase(item.getId())) {
                items.set(i, item);
                saveToFile();
                return;
            }
        }
    }

    public Flight findById(String id) {
        for (Flight f : items) {
            if (f.getId().equalsIgnoreCase(id)) {
                return f;
            }
        }
        return null;
    }
}