public class LapTrinhVien extends NhanVien {
    private int soGioOT;

    public LapTrinhVien(String maNV, String ten, double luongCoBan, int soGioOT) {
        super(maNV, ten, luongCoBan); // Gọi constructor của lớp cha (NhanVien)
        this.soGioOT = soGioOT;
    }

    // Ghi đè (override) phương thức trừu tượng từ lớp cha
    @Override
    public double tinhLuong() {
        // Ví dụ: Lương = Lương cơ bản + (Số giờ OT * 200000)
        return this.luongCoBan + (this.soGioOT * 200000);
    }

    // Có thể thêm các getters/setters khác nếu cần
    public int getSoGioOT() {
        return soGioOT;
    }

    public void setSoGioOT(int soGioOT) {
        this.soGioOT = soGioOT;
    }
}