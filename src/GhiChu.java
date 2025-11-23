import java.time.LocalDateTime;

public abstract class GhiChu {
    private String maGhiChu;
    private String tieuDe;
    private String noiDung;

    public GhiChu(String maGhiChu, String tieuDe, String noiDung) {
        this.maGhiChu = maGhiChu;
        this.tieuDe = tieuDe;
        this.noiDung = noiDung;
    }

    public String getMaGhiChu() {
        return maGhiChu;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public abstract void hienThiThongTin();
}