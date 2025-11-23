import java.io.Serializable; // TODO: Phai import de su dung

// TODO 1: (CUC KY QUAN TRONG)
// Them 'implements Serializable' vao sau ten lop
// Neu khong, chuong trinh se nem ra 'NotSerializableException'
public abstract class NhanVien implements Serializable {

    // Thuoc tinh nay de dam bao phien ban cua lop khi luu va doc la mot
    private static final long serialVersionUID = 1L;

    protected String maNV;
    protected String ten;
    protected double luongCoBan;

    public NhanVien(String maNV, String ten, double luongCoBan) {
        this.maNV = maNV;
        this.ten = ten;
        this.luongCoBan = luongCoBan;
    }

    public abstract double tinhLuong();

    public String getTen() { return this.ten; }
}
