package repository;

import model.Ticket;

public class TicketRepository extends CsvRepository<Ticket> {
    public TicketRepository() {
        super("src/main/resources/data/tickets.csv");
    }

    @Override
    protected Ticket fromCsv(String line) {
        String[] d = line.split(",");
        return new Ticket(d[0], d[1], d[2], d[3], Double.parseDouble(d[4]), d[5]);
    }

    @Override
    protected String toCsv(Ticket t) {
        return t.toCsv();
    }

    @Override
    public void update(Ticket item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(item.getId())) {
                items.set(i, item);
                saveToFile();
                return;
            }
        }
    }

    public Ticket findById(String id) {
        for (Ticket t : items) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
}