package view;

import repository.*;
import service.*;
import java.util.Scanner;

public class MenuConsole {
    private FlightRepository flightRepo = new FlightRepository();
    private TicketRepository ticketRepo = new TicketRepository();
    private CustomerRepository custRepo = new CustomerRepository();

    private BookingService bookingService = new BookingService(flightRepo, ticketRepo, custRepo);
    private ReportService reportService = new ReportService(ticketRepo);

    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("   HỆ THỐNG BÁN VÉ MÁY BAY (NHÓM 14)");
            System.out.println("==========================================");
            System.out.println("1. Xem danh sách chuyến bay");
            System.out.println("2. Đặt vé (Booking)");
            System.out.println("3. Hủy vé (Refund)");
            System.out.println("4. Báo cáo doanh thu");
            System.out.println("5. Top chuyến bay bán chạy");
            System.out.println("6. CHẠY TEST CASE TỰ ĐỘNG (10 Cases)");
            System.out.println("0. Thoát");
            System.out.print(">>> Chọn chức năng: ");

            try {
                String input = sc.nextLine();
                if (input.isEmpty()) continue;
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1: showFlights(); break;
                    case 2: handleBooking(); break;
                    case 3: handleCancel(); break;
                    case 4: reportService.printRevenue(); break;
                    case 5: reportService.printTopFlights(); break;
                    case 6: runAutoTests(); break;
                    case 0:
                        System.out.println("Đang lưu dữ liệu... Tạm biệt!");
                        System.exit(0);
                    default: System.out.println("Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            } catch (Exception e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }

    private void showFlights() {
        flightRepo.getAll().forEach(f ->
                System.out.printf("Flight: %s | %s | %s | Base: %,.0f VND\n",
                        f.getId(), f.getRoute(), f.getDepartureTime(), f.getBasePrice())
        );
    }

    private void handleBooking() {
        try {
            System.out.print("Nhập Mã Chuyến (VD: VN243): "); String fid = sc.nextLine();
            System.out.print("Nhập Mã Ghế (VD: E1): "); String sid = sc.nextLine();
            System.out.print("Nhập Mã Khách (VD: C001): "); String cid = sc.nextLine();

            double price = bookingService.bookTicket(fid, sid, cid);
            System.out.printf(">>> ĐẶT VÉ THÀNH CÔNG! Tổng tiền: %,.0f VND\n", price);
        } catch (Exception e) {
            System.err.println("ĐẶT VÉ THẤT BẠI: " + e.getMessage());
        }
    }

    private void handleCancel() {
        try {
            System.out.print("Nhập Mã Vé (TicketID): "); String tid = sc.nextLine();
            double refund = bookingService.cancelTicket(tid);
            System.out.printf(">>> HỦY THÀNH CÔNG! Số tiền hoàn lại: %,.0f VND\n", refund);
        } catch (Exception e) {
            System.err.println("HỦY VÉ THẤT BẠI: " + e.getMessage());
        }
    }

    private void runAutoTests() {
        System.out.println("Đang chạy test...");
    }
}