package repository;

import model.Customer;

public class CustomerRepository extends CsvRepository<Customer> {
    public CustomerRepository() {
        super("BTL/src/main/resources/data/customers.csv");
    }

    @Override
    protected Customer fromCsv(String line) {
        String[] d = line.split(",");
        return new Customer(d[0], d[1], d[2], d[3]);
    }

    @Override
    protected String toCsv(Customer c) {
        return c.toCsv();
    }

    @Override
    public void update(Customer item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equalsIgnoreCase(item.getId())) {
                items.set(i, item);
                saveToFile();
                return;
            }
        }
    }

    public Customer findById(String id) {
        for (Customer c : items) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }
}