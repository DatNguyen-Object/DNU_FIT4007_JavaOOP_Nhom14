import java.time.LocalDateTime;

public class SuKienSapToi extends GhiChu {
    private LocalDateTime thoiGianDienRa;
    private String diaDiem;
    private LocalDateTime thoiGianBaoThuc;
    private int soLanBaoThuc;
    private boolean xacNhanThamGia;
    private String amThanhBaoThuc;

    public SuKienSapToi(String maGhiChu, String tieuDe, String noiDung, LocalDateTime thoiGianDienRa, String diaDiem, LocalDateTime thoiGianBaoThuc, int soLanBaoThuc, boolean xacNhanThamGia, String amThanhBaoThuc) {
        super(maGhiChu, tieuDe, noiDung);
        this.thoiGianDienRa = thoiGianDienRa;
        this.diaDiem = diaDiem;
        this.thoiGianBaoThuc = thoiGianBaoThuc;
        this.soLanBaoThuc = soLanBaoThuc;
        this.xacNhanThamGia = xacNhanThamGia;
        this.amThanhBaoThuc = amThanhBaoThuc;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("--- GHI CHÚ SỰ KIỆN SẮP TỚI ---");
        System.out.println("Mã ghi chú: " + getMaGhiChu());
        System.out.println("Tiêu đề: " + getTieuDe());
        System.out.println("Nội dung: " + getNoiDung());
        System.out.println("Thời gian diễn ra: " + thoiGianDienRa);
        System.out.println("Địa điểm: " + diaDiem);
        System.out.println("Thời gian báo thức: " + thoiGianBaoThuc);
        System.out.println("Số lần báo thức: " + soLanBaoThuc);
        System.out.println("Xác nhận tham gia: " + (xacNhanThamGia ? "Đã xác nhận" : "Chưa xác nhận"));
        System.out.println("Âm thanh báo thức: " + amThanhBaoThuc);
    }
}