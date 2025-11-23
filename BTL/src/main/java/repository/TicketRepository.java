package repository;
import model.Ticket;

public class TicketRepository extends CsvRepository<Ticket> {
    public TicketRepository() {
        // 👇 SỬA ĐƯỜNG DẪN TƯƠNG TỰ CHO TICKET
        super("C:\\Users\\Admin\\IdeaProjects\\DNU_FIT4007_JavaOOP_Nhom14\\BTL\\src\\main\\resources\\data\\tickets.csv");
    }

    // ... (Giữ nguyên phần dưới)
    @Override protected Ticket fromCsv(String line) {
        try {
            String[] d = line.split(",");
            if (d.length < 6) return null;
            return new Ticket(d[0], d[1], d[2], d[3], Double.parseDouble(d[4]), d[5]);
        } catch (Exception e) { return null; }
    }
    @Override protected String toCsv(Ticket t) { return t.toCsv(); }
    @Override public void update(Ticket item) {
        for(int i=0; i<items.size(); i++) {
            if(items.get(i).getId().equals(item.getId())) {
                items.set(i, item); save(items); return;
            }
        }
    }
    public Ticket findById(String id) {
        return items.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }
}