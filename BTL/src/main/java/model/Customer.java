package model;

public class Customer extends Person {
    public String email; // Vẫn để public
    public String cccd;

    public Customer(String id, String name, String phone, String email, String cccd) {
        super(id, name, phone);
        this.email = email;
        this.cccd = cccd;
    }
}