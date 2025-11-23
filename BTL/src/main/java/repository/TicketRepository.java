package repository;
import model.Ticket;

public class TicketRepository extends CsvRepository<Ticket> {
    public TicketRepository() {
        super("src/main/resources/data/tickets.csv");
    }

    @Override
    protected Ticket fromCsv(String line) {
        String[] d = line.split(",");
        // ID, FlightID, SeatID, CustID, Price, Status
        return new Ticket(d[0], d[1], d[2], d[3], Double.parseDouble(d[4]), d[5]);
    }

    @Override
    protected String toCsv(Ticket t) { return t.toCsv(); }

    public void update(Ticket t) {
        save(items);
    }

    public Ticket findById(String id) {
        return items.stream().filter(t -> t.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}