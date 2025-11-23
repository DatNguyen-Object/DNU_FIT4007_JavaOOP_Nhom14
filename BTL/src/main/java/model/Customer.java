package model;

public class Customer extends Person {
    private String email;
    private String cccd;

    public Customer(String id, String name, String phone, String email, String cccd) {
        super(id, name, phone);
        this.email = email;
        this.cccd = cccd;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getCccd() { return cccd; }

    // Hàm tiện ích để Repository ghi xuống file CSV dễ dàng
    public String toCsv() {
        // Format: ID,Name,Phone,Email,CCCD
        return String.join(",", id, name, phone, email, cccd);
    }

    @Override
    public String toString() {
        return "KH: " + name + " | SĐT: " + phone;
    }
}