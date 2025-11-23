import view.MenuConsole;

public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   AIRLINE RESERVATION SYSTEM (v1.0)   ");
        System.out.println("   Developed by Group 14: Viet Anh, Dat, Quyet");
        System.out.println("=========================================");

        try {
            // Khởi động ứng dụng
            MenuConsole app = new MenuConsole();
            app.start();
        } catch (Exception e) {
            // Bắt lỗi không lường trước (Global Exception Handler)
            System.err.println("CRITICAL ERROR: Hệ thống gặp lỗi không mong muốn!");
            e.printStackTrace();
        } finally {
            System.out.println("\n>>> Cảm ơn quý khách đã sử dụng dịch vụ!");
        }
    }
}