package view;
import service.*;
import java.util.Scanner;

public class MenuConsole {
    private BookingService bookingService = new BookingService();
    private ReportService reportService = new ReportService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while(true) {
            System.out.println("1. Đặt vé | 2. Báo cáo | 3. Test | 0. Thoát");
            String chon = sc.nextLine();
            switch(chon) {
                case "1": handleBooking(); break;
                case "2": reportService.printRevenue(); break;
                case "3": runTests(); break;
                case "0": return;
            }
        }
    }

    private void handleBooking() {
        try {
            System.out.print("Mã chuyến: "); String fid = sc.nextLine();
            System.out.print("Mã ghế: "); String sid = sc.nextLine();
            double price = bookingService.bookTicket(fid, sid);
            System.out.printf("Thành công! Giá: %,.0f\n", price);
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    // Hàm runTests() ở bước sau
}