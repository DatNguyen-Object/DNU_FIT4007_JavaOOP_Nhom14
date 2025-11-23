package repository;
import model.Customer;

public class CustomerRepository extends CsvRepository<Customer> {
    public CustomerRepository() {
        // 👇 SỬA ĐƯỜNG DẪN TƯƠNG TỰ CHO CUSTOMER
        super("C:\\Users\\Admin\\IdeaProjects\\DNU_FIT4007_JavaOOP_Nhom14\\BTL\\src\\main\\resources\\data\\customers.csv");
    }

    // ... (Giữ nguyên phần dưới)
    @Override protected Customer fromCsv(String line) {
        try {
            String[] d = line.split(",");
            if (d.length < 5) return null;
            return new Customer(d[0], d[1], d[2], d[3], d[4]);
        } catch (Exception e) { return null; }
    }
    @Override protected String toCsv(Customer c) { return c.toCsv(); }
    @Override public void update(Customer item) {}
    public Customer findById(String id) {
        return items.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}