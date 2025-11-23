package repository;
import model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public CustomerRepository() {
        customers.add(new Customer("C001", "Nguyen Van A", "0901234567", "a@gmail.com", "001200"));
    }

    public Customer findById(String id) {
        for (Customer c : customers) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }
}