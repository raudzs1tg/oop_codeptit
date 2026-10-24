import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class SanPham {
    String MaLoai;
    String TenSanPham;
    long DonGiaMot;
    long DonGiaHai;

    public SanPham(String MaLoai, String TenSanPham, long DonGiaMot, long DonGiaHai) {
        this.MaLoai = MaLoai;
        this.TenSanPham = TenSanPham;
        this.DonGiaMot = DonGiaMot;
        this.DonGiaHai = DonGiaHai;
    }
}

class HoaDon {
    String MaHoaDon;
    String TenSanPham;
    long TienGiamGia;
    long TienPhaiTra;

    public HoaDon(String MaHoaDon, String TenSanPham, long TienGiamGia, long TienPhaiTra) {
        this.MaHoaDon = MaHoaDon;
        this.TenSanPham = TenSanPham;
        this.TienGiamGia = TienGiamGia;
        this.TienPhaiTra = TienPhaiTra;
    }
}

public class Bai02 {
    public static void main(String[] args) {
        Scanner BanPhim = new Scanner(System.in);
        if (!BanPhim.hasNextInt()) return;
        
        int SoLuongSanPham = BanPhim.nextInt();
        BanPhim.nextLine();

        HashMap<String, SanPham> DanhSachSanPham = new HashMap<>();

        for (int ChiSo = 0; ChiSo < SoLuongSanPham; ChiSo++) {
            String MaLoai = BanPhim.nextLine().trim();
            String TenSanPham = BanPhim.nextLine().trim();
            long DonGiaMot = BanPhim.nextLong();
            long DonGiaHai = BanPhim.nextLong();
            BanPhim.nextLine(); 

            DanhSachSanPham.put(MaLoai, new SanPham(MaLoai, TenSanPham, DonGiaMot, DonGiaHai));
        }

        int SoLuongHoaDon = BanPhim.nextInt();
        BanPhim.nextLine(); 

        ArrayList<HoaDon> DanhSachHoaDon = new ArrayList<>();
        int SoThuTuToanCuc = 1; 

        for (int ChiSo = 0; ChiSo < SoLuongHoaDon; ChiSo++) {
            String DongDuLieu = BanPhim.nextLine().trim();
            String[] CacPhan = DongDuLieu.split("\\s+");
            String MaBanDau = CacPhan[0]; 
            long SoLuongMua = Long.parseLong(CacPhan[1]);

            String MaLoai = MaBanDau.substring(0, 2);
            char LoaiSanPham = MaBanDau.charAt(2);

            String MaHoaDonDayDu = MaBanDau + "-" + String.format("%03d", SoThuTuToanCuc++);

            SanPham SanPhamHienTai = DanhSachSanPham.get(MaLoai);

            long DonGia = (LoaiSanPham == '1') ? SanPhamHienTai.DonGiaMot : SanPhamHienTai.DonGiaHai;
            long ThanhTien = DonGia * SoLuongMua;

            double PhanTramGiamGia = 0;
            if (SoLuongMua >= 150) {
                PhanTramGiamGia = 0.50;
            } else if (SoLuongMua >= 100) {
                PhanTramGiamGia = 0.30;
            } else if (SoLuongMua >= 50) {
                PhanTramGiamGia = 0.15;
            }

            long TienGiamGia = Math.round(ThanhTien * PhanTramGiamGia);
            long TienPhaiTra = ThanhTien - TienGiamGia;

            DanhSachHoaDon.add(new HoaDon(MaHoaDonDayDu, SanPhamHienTai.TenSanPham, TienGiamGia, TienPhaiTra));
        }

        for (HoaDon DoiTuongHoaDon : DanhSachHoaDon) {
            System.out.println(DoiTuongHoaDon.MaHoaDon + " " + 
                               DoiTuongHoaDon.TenSanPham + " " + 
                               DoiTuongHoaDon.TienGiamGia + " " + 
                               DoiTuongHoaDon.TienPhaiTra);
        }
    }
}