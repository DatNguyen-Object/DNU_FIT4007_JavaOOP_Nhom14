package repository;
import common.DateUtils;
import model.Flight;
import java.util.List;

public class FlightRepository extends CsvRepository<Flight> {
    public FlightRepository() {
        super("src/main/resources/data/flights.csv");
    }

    @Override
    protected Flight fromCsv(String line) {
        String[] data = line.split(",");
        return new Flight(
                data[0], data[1],
                DateUtils.fromString(data[2]),
                Double.parseDouble(data[3])
        );
    }

    @Override
    protected String toCsv(Flight entity) {
        return String.join(",", entity.getId(), entity.getRoute(),
                DateUtils.toString(entity.getDepartureTime()),
                String.valueOf(entity.getBasePrice()));
    }

    public Flight findById(String id) {
        return items.stream().filter(f -> f.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}