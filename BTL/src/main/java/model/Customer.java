package model;

public class Customer extends Person {
    private String email;

    public Customer(String id, String name, String phone, String email) {
        super(id, name, phone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toCsv() {
        return id + "," + name + "," + phone + "," + email;
    }
}