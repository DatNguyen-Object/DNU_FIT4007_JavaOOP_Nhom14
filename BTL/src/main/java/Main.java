import model.BusinessSeat;
import model.EconomySeat;
import model.Flight;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Code rác để test thử Model
        System.out.println("--- TEST APP ---");

        EconomySeat s1 = new EconomySeat("E1", false);
        System.out.println("Ghe thuong: " + s1.getSurcharge()); // Check xem ra 0 ko

        BusinessSeat s2 = new BusinessSeat("B1", false);
        System.out.println("Ghe VIP: " + s2.getSurcharge()); // Check xem ra 500k ko

        Flight f = new Flight("VN001", "HN-HCM", LocalDateTime.now(), 1000);
        System.out.println("Chuyen bay: " + f.getId() + " co " + f.getSeats().size() + " ghe");
    }
}