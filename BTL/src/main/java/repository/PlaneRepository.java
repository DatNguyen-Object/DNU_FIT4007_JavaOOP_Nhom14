package repository;

import model.Plane;

public class PlaneRepository extends CsvRepository<Plane> {
    public PlaneRepository() {
        super("src/main/resources/data/planes.csv");
    }

    @Override
    protected Plane fromCsv(String line) {
        String[] d = line.split(",");
        return new Plane(d[0], d[1], Integer.parseInt(d[2]));
    }

    @Override
    protected String toCsv(Plane p) {
        return p.toCsv();
    }

    @Override
    public void update(Plane item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equalsIgnoreCase(item.getId())) {
                items.set(i, item);
                saveToFile();
                return;
            }
        }
    }

    public Plane findById(String id) {
        for (Plane p : items) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}