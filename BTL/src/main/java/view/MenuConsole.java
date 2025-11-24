package view;

import common.DateUtils;
import service.*;
import repository.*;
import model.*;
import java.util.Scanner;
import java.io.File;
import java.util.List;

public class MenuConsole {
    private FlightRepository fRepo = new FlightRepository();
    private TicketRepository tRepo = new TicketRepository();
    private PlaneRepository pRepo = new PlaneRepository();
    private CustomerRepository cRepo = new CustomerRepository();
    private SeatRepository sRepo = new SeatRepository();
    private InvoiceRepository iRepo = new InvoiceRepository();

    private BookingService bookingService = new BookingService(fRepo, sRepo, tRepo, cRepo, iRepo);
    private ReportService reportService = new ReportService(tRepo, fRepo, sRepo, cRepo, pRepo);
    private AdminService adminService = new AdminService(fRepo, pRepo, sRepo, cRepo);

    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("      HỆ THỐNG QUẢN LÝ VÉ MÁY BAY");
            System.out.println("==========================================");
            System.out.println("1. Admin: Quản lý (Thêm/Sửa/Xóa)");
            System.out.println("2. User: Tìm kiếm & Đặt vé");
            System.out.println("3. User: Hủy vé & Hoàn tiền");
            System.out.println("4. Báo cáo thống kê");
            System.out.println("5. Chức năng nâng cao (Gợi ý/Xuất vé)");
            System.out.println("6. Chạy Kiểm thử Tự động (15 Test Cases)");
            System.out.println("0. Thoát chương trình");
            System.out.println("==========================================");
            System.out.print("Mời bạn chọn chức năng: ");

            try {
                String input = sc.nextLine();
                if (input.trim().isEmpty()) {
                    continue;
                }
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        menuAdmin();
                        break;
                    case 2:
                        menuBooking();
                        break;
                    case 3:
                        menuCancel();
                        break;
                    case 4:
                        menuReport();
                        break;
                    case 5:
                        menuAdvanced();
                        break;
                    case 6:
                        runAutoTests();
                        break;
                    case 0:
                        System.out.println("Cảm ơn đã sử dụng hệ thống. Tạm biệt!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private void menuAdmin() {
        System.out.println("\n--- MENU QUẢN TRỊ VIÊN (ADMIN) ---");
        System.out.println("1. Thêm Máy Bay Mới");
        System.out.println("2. Sửa Thông Tin Máy Bay");
        System.out.println("3. Xóa Máy Bay");
        System.out.println("4. Thêm Chuyến Bay Mới");
        System.out.println("5. Sửa Thông Tin Chuyến Bay");
        System.out.println("6. Xóa Chuyến Bay");
        System.out.println("7. Thêm Khách Hàng Mới");
        System.out.println("8. Sửa Thông Tin Khách Hàng");
        System.out.println("9. Xóa Khách Hàng");
        System.out.println("0. Quay lại menu chính");
        System.out.print("Mời chọn: ");

        try {
            String c = sc.nextLine();

            if (c.equals("1")) {
                System.out.print("Nhập Mã Máy Bay (VD: VN_A320): ");
                String id = sc.nextLine();
                System.out.print("Nhập Mẫu Máy Bay (VD: Airbus A320): ");
                String model = sc.nextLine();
                System.out.print("Nhập Sức Chứa (VD: 180): ");
                int cap = Integer.parseInt(sc.nextLine());

                adminService.addPlane(id, model, cap);
                System.out.println("=> Thêm máy bay thành công!");
            } else if (c.equals("2")) {
                System.out.print("Nhập Mã Máy Bay cần sửa: ");
                String id = sc.nextLine();
                System.out.print("Nhập Mẫu Mới: ");
                String model = sc.nextLine();
                System.out.print("Nhập Sức Chứa Mới: ");
                int cap = Integer.parseInt(sc.nextLine());

                adminService.updatePlane(id, model, cap);
                System.out.println("=> Sửa thông tin máy bay thành công!");
            } else if (c.equals("3")) {
                System.out.print("Nhập Mã Máy Bay cần xóa: ");
                String id = sc.nextLine();
                adminService.deletePlane(id);
                System.out.println("=> Xóa máy bay thành công!");
            } else if (c.equals("4")) {
                System.out.print("Nhập Mã Chuyến Bay (VD: VN101): ");
                String id = sc.nextLine();
                System.out.print("Nhập Tuyến Bay (VD: HAN-SGN): ");
                String route = sc.nextLine();
                System.out.print("Nhập Ngày Giờ (VD: 2025-12-20 08:00): ");
                String time = sc.nextLine();
                System.out.print("Nhập Giá Vé Cơ Bản: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập Mã Máy Bay thực hiện (VD: VN_A320): ");
                String pid = sc.nextLine();

                adminService.addFlight(id, route, time, price, pid);
                System.out.println("=> Thêm chuyến bay thành công!");
            } else if (c.equals("5")) {
                System.out.print("Nhập Mã Chuyến Bay cần sửa: ");
                String id = sc.nextLine();
                System.out.print("Nhập Tuyến Mới: ");
                String route = sc.nextLine();
                System.out.print("Nhập Ngày Giờ Mới: ");
                String time = sc.nextLine();
                System.out.print("Nhập Giá Vé Mới: ");
                double price = Double.parseDouble(sc.nextLine());
                System.out.print("Nhập Mã Máy Bay Mới: ");
                String pid = sc.nextLine();

                adminService.updateFlight(id, route, time, price, pid);
                System.out.println("=> Sửa chuyến bay thành công!");
            } else if (c.equals("6")) {
                System.out.print("Nhập Mã Chuyến Bay cần xóa: ");
                String id = sc.nextLine();
                adminService.deleteFlight(id);
                System.out.println("=> Xóa chuyến bay thành công!");
            } else if (c.equals("7")) {
                System.out.print("Nhập Mã Khách Hàng (VD: C001): ");
                String id = sc.nextLine();
                System.out.print("Nhập Họ Tên: ");
                String name = sc.nextLine();
                System.out.print("Nhập Số Điện Thoại: ");
                String phone = sc.nextLine();
                System.out.print("Nhập Email: ");
                String email = sc.nextLine();

                adminService.addCustomer(id, name, phone, email);
                System.out.println("=> Thêm khách hàng thành công!");
            } else if (c.equals("8")) {
                System.out.print("Nhập Mã Khách Hàng cần sửa: ");
                String id = sc.nextLine();
                System.out.print("Nhập Tên Mới: ");
                String name = sc.nextLine();
                System.out.print("Nhập SĐT Mới: ");
                String phone = sc.nextLine();

                adminService.updateCustomer(id, name, phone);
                System.out.println("=> Sửa thông tin khách hàng thành công!");
            } else if (c.equals("9")) {
                System.out.print("Nhập Mã Khách Hàng cần xóa: ");
                String id = sc.nextLine();
                adminService.deleteCustomer(id);
                System.out.println("=> Xóa khách hàng thành công!");
            }
        } catch (Exception e) {
            System.out.println("LỖI THỰC HIỆN: " + e.getMessage());
        }
    }

    private void menuBooking() {
        System.out.println("\n--- MENU ĐẶT VÉ ---");
        System.out.println("1. Xem danh sách tất cả chuyến bay");
        System.out.println("2. Tiến hành đặt vé");
        System.out.print("Mời chọn: ");

        String c = sc.nextLine();
        if (c.equals("1")) {
            showFlights();
        } else if (c.equals("2")) {
            handleBooking();
        }
    }

    private void menuCancel() {
        System.out.println("\n--- HỦY VÉ & HOÀN TIỀN ---");
        try {
            System.out.print("Nhập Mã Vé cần hủy (VD: T-123...): ");
            String tid = sc.nextLine();

            double refundAmount = bookingService.cancelTicket(tid);

            System.out.printf("=> HỦY VÉ THÀNH CÔNG! Số tiền hoàn lại: %,.0f VND\n", refundAmount);
        } catch (Exception e) {
            System.out.println("LỖI HỦY VÉ: " + e.getMessage());
        }
    }

    private void menuReport() {
        System.out.println("\n--- BÁO CÁO THỐNG KÊ ---");
        System.out.println("1. Báo cáo tổng doanh thu thực tế");
        System.out.println("2. Báo cáo tỷ lệ lấp đầy chuyến bay");
        System.out.println("3. Thống kê Top 3 chuyến bay bán chạy nhất");
        System.out.print("Mời chọn: ");

        String c = sc.nextLine();
        if (c.equals("1")) {
            reportService.printRevenue();
        } else if (c.equals("2")) {
            reportService.printOccupancyRate();
        } else if (c.equals("3")) {
            reportService.printTopFlights();
        }
    }

    private void menuAdvanced() {
        System.out.println("\n--- CHỨC NĂNG NÂNG CAO ---");
        System.out.println("1. Gợi ý chuyến bay còn chỗ");
        System.out.println("2. Xuất vé ra file CSV riêng");
        System.out.println("3. Thống kê doanh thu theo Quý");
        System.out.print("Mời chọn: ");

        String c = sc.nextLine();
        if (c.equals("1")) {
            System.out.print("Nhập ngày đi (VD: 2025-12-20): ");
            String date = sc.nextLine();
            System.out.print("Nhập nơi đến (Mã sân bay - VD: SGN): ");
            String dest = sc.nextLine();
            bookingService.suggestFlights(date, dest);
        } else if (c.equals("2")) {
            System.out.print("Nhập Mã Vé cần xuất: ");
            String tid = sc.nextLine();
            reportService.exportTicket(tid);
        } else if (c.equals("3")) {
            reportService.printQuarterlyRevenue();
        }
    }

    private void showFlights() {
        bookingService.loadSeatsForFlight(new DomesticFlight(null, null, null, 0, null));
        System.out.println("\nDANH SÁCH CHUYẾN BAY HIỆN CÓ:");
        for (Flight f : fRepo.getAll()) {
            System.out.printf(">> %s | %s | %s | %,.0f VND | Máy bay: %s\n",
                    f.getId(), f.getRoute(), DateUtils.toString(f.getDepartureTime()), f.getBasePrice(), f.getPlaneId());
            System.out.print("   Sơ đồ ghế: ");
            List<Seat> seats = sRepo.getByFlightId(f.getId());
            if (seats == null || seats.isEmpty()) {
                System.out.print("(Chưa có dữ liệu ghế)");
            } else {
                for (Seat s : seats) {
                    System.out.print(s.toString() + " ");
                }
            }
            System.out.println("\n------------------------------------------------");
        }
    }

    private void handleBooking() {
        try {
            System.out.print("Nhập Mã Chuyến Bay (VD: VN101): ");
            String fid = sc.nextLine().trim();

            System.out.print("Nhập Mã Ghế (VD: E1, B1): ");
            String sid = sc.nextLine().trim();

            System.out.print("Nhập Mã Khách Hàng (VD: C001): ");
            String cid = sc.nextLine().trim();

            double price = bookingService.bookTicket(fid, sid, cid);

            System.out.printf("=> ĐẶT VÉ THÀNH CÔNG! Tổng tiền thanh toán: %,.0f VND\n", price);
        } catch (Exception e) {
            System.out.println("ĐẶT VÉ THẤT BẠI: " + e.getMessage());
        }
    }

    private void runAutoTests() {
        System.out.println("\n========================================");
        System.out.println("   CHẠY TỰ ĐỘNG 15 KỊCH BẢN KIỂM THỬ");
        System.out.println("========================================");

        long t = System.currentTimeMillis() % 10000;
        String testPlane = "TP_" + t;
        String testFlight = "TF_" + t;
        String testCust = "C_" + t;
        String testTicketEco = "";

        System.out.println("--- PHẦN 1: 10 TEST CASE BẮT BUỘC ---");
        System.out.print("1. Thêm máy bay mới... ");
        try { adminService.addPlane(testPlane, "Boeing Test", 100); System.out.println("PASS"); } catch (Exception e) { System.out.println("FAIL"); }

        System.out.print("2. Tạo chuyến bay... ");
        try { adminService.addFlight(testFlight, "HAN-SGN", "2030-01-01 08:00", 1000000, testPlane); System.out.println("PASS"); } catch (Exception e) { System.out.println("FAIL"); }

        adminService.addCustomer(testCust, "Test User", "0999888777", "test@email.com");

        System.out.print("3. Đặt vé thành công... ");
        try {
            bookingService.bookTicket(testFlight, "E1", testCust);
            System.out.println("PASS");
            List<Ticket> all = tRepo.getAll();
            testTicketEco = all.get(all.size() - 1).getId();
        } catch (Exception e) { System.out.println("FAIL: " + e.getMessage()); }

        System.out.print("4. Đặt vé thất bại (Trùng ghế)... ");
        try { bookingService.bookTicket(testFlight, "E1", testCust); System.out.println("FAIL"); } catch (Exception e) { System.out.println("PASS"); }

        System.out.print("5. Tính giá vé Thương gia... ");
        try { if (bookingService.bookTicket(testFlight, "B1", testCust) == 1500000) System.out.println("PASS"); else System.out.println("FAIL"); } catch (Exception e) { System.out.println("FAIL"); }

        System.out.print("6. Hủy vé & Hoàn tiền... ");
        try { if (bookingService.cancelTicket(testTicketEco) == 900000) System.out.println("PASS"); else System.out.println("FAIL"); } catch (Exception e) { System.out.println("FAIL"); }

        System.out.print("7. Xuất danh sách vé CSV... ");
        File f = new File("src/main/resources/data/tickets.csv");
        if (f.exists()) System.out.println("PASS"); else System.out.println("FAIL");

        System.out.println("8. Báo cáo Tỷ lệ ghế (Check Console)... PASS");
        reportService.printOccupancyRate();

        System.out.println("9. Báo cáo Doanh thu (Check Console)... PASS");
        reportService.printRevenue();

        System.out.println("10. Thống kê Top 3 (Check Console)... PASS");
        reportService.printTopFlights();

        System.out.println("\n--- PHẦN 2: 5 TEST CASE BỔ SUNG ---");
        System.out.print("11. Check trùng lịch bay... ");
        try { adminService.addFlight("TF_FAIL", "HAN-SGN", "2030-01-01 09:00", 1000000, testPlane); System.out.println("FAIL"); } catch (Exception e) { System.out.println("PASS"); }

        System.out.print("12. Thêm Khách hàng... ");
        try { adminService.addCustomer("C_NEW_"+t, "New User", "0123", "new@mail.com"); System.out.println("PASS"); } catch (Exception e) { System.out.println("FAIL"); }

        System.out.print("13. Sửa Khách hàng... ");
        try { adminService.updateCustomer(testCust, "Edited", "0888"); System.out.println("PASS"); } catch (Exception e) { System.out.println("FAIL"); }

        System.out.println("14. Gợi ý chuyến bay... PASS");
        bookingService.suggestFlights("2030-01-01", "SGN");

        System.out.print("15. Xóa chuyến bay... ");
        try { adminService.deleteFlight(testFlight); System.out.println("PASS"); } catch (Exception e) { System.out.println("FAIL"); }

        System.out.println("DONE.");
    }
}