import java.util.ArrayList;
import java.util.Scanner;

class KhachHang {
    String MaKhachHang;
    String TenKhachHang;
    String GioiTinh;
    String NgaySinh;
    String DiaChi;

    public KhachHang(int ThuTu, String TenKhachHang, String GioiTinh, String NgaySinh, String DiaChi) {
        this.MaKhachHang = String.format("KH%03d", ThuTu);
        this.TenKhachHang = TenKhachHang;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
    }
}

class MatHang {
    String MaMatHang;
    String TenMatHang;
    String DonViTinh;
    long GiaMua;
    long GiaBan;

    public MatHang(int ThuTu, String TenMatHang, String DonViTinh, long GiaMua, long GiaBan) {
        this.MaMatHang = String.format("MH%03d", ThuTu);
        this.TenMatHang = TenMatHang;
        this.DonViTinh = DonViTinh;
        this.GiaMua = GiaMua;
        this.GiaBan = GiaBan;
    }
}

class HoaDon {
    String MaHoaDon;
    KhachHang ThongTinKhachHang;
    MatHang ThongTinMatHang;
    long SoLuong;
    long ThanhTien;

    public HoaDon(int ThuTu, KhachHang ThongTinKhachHang, MatHang ThongTinMatHang, long SoLuong) {
        this.MaHoaDon = String.format("HD%03d", ThuTu);
        this.ThongTinKhachHang = ThongTinKhachHang;
        this.ThongTinMatHang = ThongTinMatHang;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThongTinMatHang.GiaBan * SoLuong;
    }
}

public class Bai04 {
    public static void main(String[] args) {
        Scanner BanPhim = new Scanner(System.in);
        if (!BanPhim.hasNextInt()) return;

        int SoLuongKhachHang = BanPhim.nextInt();
        BanPhim.nextLine();
        ArrayList<KhachHang> DanhSachKhachHang = new ArrayList<>();
        for (int ChiSo = 1; ChiSo <= SoLuongKhachHang; ChiSo++) {
            String TenKhachHang = BanPhim.nextLine().trim();
            String GioiTinh = BanPhim.nextLine().trim();
            String NgaySinh = BanPhim.nextLine().trim();
            String DiaChi = BanPhim.nextLine().trim();
            DanhSachKhachHang.add(new KhachHang(ChiSo, TenKhachHang, GioiTinh, NgaySinh, DiaChi));
        }

        int SoLuongMatHang = BanPhim.nextInt();
        BanPhim.nextLine(); 
        ArrayList<MatHang> DanhSachMatHang = new ArrayList<>();
        for (int ChiSo = 1; ChiSo <= SoLuongMatHang; ChiSo++) {
            String TenMatHang = BanPhim.nextLine().trim();
            String DonViTinh = BanPhim.nextLine().trim();
            long GiaMua = BanPhim.nextLong();
            long GiaBan = BanPhim.nextLong();
            BanPhim.nextLine(); 
            DanhSachMatHang.add(new MatHang(ChiSo, TenMatHang, DonViTinh, GiaMua, GiaBan));
        }

        int SoLuongHoaDon = BanPhim.nextInt();
        BanPhim.nextLine(); 
        ArrayList<HoaDon> DanhSachHoaDon = new ArrayList<>();
        for (int ChiSo = 1; ChiSo <= SoLuongHoaDon; ChiSo++) {
            String MaKhachHang = BanPhim.next();
            String MaMatHang = BanPhim.next();
            long SoLuong = BanPhim.nextLong();
            if (BanPhim.hasNextLine()) {
                BanPhim.nextLine();
            }

            KhachHang KhachHangTimDuoc = null;
            for (KhachHang DoiTuongKhachHang : DanhSachKhachHang) {
                if (DoiTuongKhachHang.MaKhachHang.equals(MaKhachHang)) {
                    KhachHangTimDuoc = DoiTuongKhachHang;
                    break;
                }
            }

            MatHang MatHangTimDuoc = null;
            for (MatHang DoiTuongMatHang : DanhSachMatHang) {
                if (DoiTuongMatHang.MaMatHang.equals(MaMatHang)) {
                    MatHangTimDuoc = DoiTuongMatHang;
                    break;
                }
            }

            DanhSachHoaDon.add(new HoaDon(ChiSo, KhachHangTimDuoc, MatHangTimDuoc, SoLuong));
        }

        for (HoaDon DoiTuongHoaDon : DanhSachHoaDon) {
            System.out.println(DoiTuongHoaDon.MaHoaDon + " " +
                    DoiTuongHoaDon.ThongTinKhachHang.TenKhachHang + " " +
                    DoiTuongHoaDon.ThongTinKhachHang.DiaChi + " " +
                    DoiTuongHoaDon.ThongTinMatHang.TenMatHang + " " +
                    DoiTuongHoaDon.ThongTinMatHang.DonViTinh + " " +
                    DoiTuongHoaDon.ThongTinMatHang.GiaMua + " " +
                    DoiTuongHoaDon.ThongTinMatHang.GiaBan + " " +
                    DoiTuongHoaDon.SoLuong + " " +
                    DoiTuongHoaDon.ThanhTien);
        }
    }
}