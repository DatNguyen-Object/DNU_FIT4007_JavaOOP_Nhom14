package repository;
import model.Flight;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FlightRepository implements Persistable<Flight> {
    private static final String PATH = "src/main/resources/data/flights.csv";

    @Override
    public List<Flight> load() {
        List<Flight> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                Flight f = new Flight(d[0], d[1], LocalDateTime.parse(d[2]), Double.parseDouble(d[3]));
                list.add(f);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    @Override
    public void save(List<Flight> data) {

    }
    public List<Flight> getAll() { return load(); }
}