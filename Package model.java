package model;

// Abstract class Seat
public abstract class Seat {
    protected String seatId;
    protected boolean isBooked;
    protected double basePrice; // Giá gốc từ chuyến bay

    public Seat(String seatId, double basePrice) {
        this.seatId = seatId;
        this.basePrice = basePrice;
        this.isBooked = false;
    }

    // Phương thức abstract buộc các lớp con phải tự định nghĩa
    public abstract double getSurcharge();

    // Tính tổng giá vé cho ghế này
    public double getFinalPrice() {
        return basePrice + getSurcharge();
    }

    public boolean isBooked() { return isBooked; }
    public void setBooked(boolean booked) { isBooked = booked; }
    public String getSeatId() { return seatId; }
    
    // Dùng để ghi ra CSV: ID,Type,Status
    @Override
    public String toString() {
        return seatId + "," + this.getClass().getSimpleName() + "," + (isBooked ? "BOOKED" : "AVAILABLE");
    }
}

// Hạng Thương gia (Business)
package model;

public class BusinessSeat extends Seat {
    public BusinessSeat(String seatId, double basePrice) {
        super(seatId, basePrice);
    }

    @Override
    public double getSurcharge() {
        // Ví dụ: Phụ phí 500,000 VND
        return 500000.0; 
    }
}

// Hạng Phổ thông (Economy)
package model;

public class EconomySeat extends Seat {
    public EconomySeat(String seatId, double basePrice) {
        super(seatId, basePrice);
    }

    @Override
    public double getSurcharge() {
        return 0.0; // Không có phụ phí
    }
}