package view;
import repository.FlightRepository;
import service.BookingService;
import java.util.Scanner;

public class MenuConsole {
    private BookingService bookingService = new BookingService(); // Chưa dùng Dependency Injection

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Dat ve");
        System.out.println("2. Thoat");
        int chon = sc.nextInt(); // Dễ lỗi nếu nhập chữ

        if (chon == 1) {
            System.out.println("Nhap ma chuyen bay: ");
            String fid = sc.next();
            System.out.println("Nhap ma ghe: ");
            String sid = sc.next();
            bookingService.bookTicket(fid, sid); // Hàm này chưa return giá tiền
        }
    }
}