import java.time.LocalDateTime;

public class SuViecDaQua extends GhiChu {
    private LocalDateTime thoiGianXayRa;
    private String diaDiem;
    private String nguoiLienQuan;
    private String ketQua;
    private String danhGia;

    public SuViecDaQua(String maGhiChu, String tieuDe, String noiDung, LocalDateTime thoiGianXayRa, String diaDiem, String nguoiLienQuan, String ketQua, String danhGia) {
        super(maGhiChu, tieuDe, noiDung);
        this.thoiGianXayRa = thoiGianXayRa;
        this.diaDiem = diaDiem;
        this.nguoiLienQuan = nguoiLienQuan;
        this.ketQua = ketQua;
        this.danhGia = danhGia;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("--- GHI CHÚ SỰ VIỆC ĐÃ QUA ---");
        System.out.println("Mã ghi chú: " + getMaGhiChu());
        System.out.println("Tiêu đề: " + getTieuDe());
        System.out.println("Nội dung: " + getNoiDung());
        System.out.println("Thời gian xảy ra: " + thoiGianXayRa);
        System.out.println("Địa điểm: " + diaDiem);
        System.out.println("Người liên quan: " + nguoiLienQuan);
        System.out.println("Kết quả: " + ketQua);
        System.out.println("Đánh giá: " + danhGia);
    }
}