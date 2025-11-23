public class MathUtils {

    // Nạp chồng cho hai số nguyên
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Nạp chồng cho ba số nguyên
    public int max(int a, int b, int c) {
        return max(max(a, b), c);
    }

    // Nạp chồng cho hai số thực
    public double max(double a, double b) {
        return (a > b) ? a : b;
    }
}