public class KiemThuVien extends NhanVien {
    private int soBugTimDuoc;

    public KiemThuVien(String maNV, String ten, double luongCoBan, int soBugTimDuoc) {
        super(maNV, ten, luongCoBan); // Gọi constructor của lớp cha (NhanVien)
        this.soBugTimDuoc = soBugTimDuoc;
    }

    // Ghi đè (override) phương thức trừu tượng từ lớp cha
    @Override
    public double tinhLuong() {
        // Ví dụ: Lương = Lương cơ bản + (Số bug tìm được * 50000)
        return this.luongCoBan + (this.soBugTimDuoc * 50000);
    }

    // Có thể thêm các getters/setters khác nếu cần
    public int getSoBugTimDuoc() {
        return soBugTimDuoc;
    }

    public void setSoBugTimDuoc(int soBugTimDuoc) {
        this.soBugTimDuoc = soBugTimDuoc;
    }
}