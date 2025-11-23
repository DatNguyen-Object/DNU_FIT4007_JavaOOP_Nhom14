package repository;
import model.Customer;

public class CustomerRepository extends CsvRepository<Customer> {
    public CustomerRepository() {
        super("src/main/resources/data/customers.csv");
    }

    @Override
    protected Customer fromCsv(String line) {
        String[] d = line.split(",");
        return new Customer(d[0], d[1], d[2], d[3], d[4]);
    }

    @Override
    protected String toCsv(Customer c) { return c.toCsv(); }

    public Customer findById(String id) {
        return items.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}