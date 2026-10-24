import java.util.ArrayList;
import java.util.Scanner;

class SinhVien {
    String MaSinhVien;
    String HoTen;
    String SoDienThoai;
    int SoThuTuNhom;

    public SinhVien(String MaSinhVien, String HoTen, String SoDienThoai, int SoThuTuNhom) {
        this.MaSinhVien = MaSinhVien;
        this.HoTen = HoTen;
        this.SoDienThoai = SoDienThoai;
        this.SoThuTuNhom = SoThuTuNhom;
    }
}

public class Bai05 {
    public static void main(String[] args) {
        Scanner BanPhim = new Scanner(System.in);
        if (!BanPhim.hasNextInt()) return;

        int SoLuongSinhVien = BanPhim.nextInt();
        int SoLuongNhom = BanPhim.nextInt();
        BanPhim.nextLine();

        ArrayList<SinhVien> DanhSachSinhVien = new ArrayList<>();
        for (int ChiSo = 0; ChiSo < SoLuongSinhVien; ChiSo++) {
            String MaSinhVien = BanPhim.nextLine().trim();
            String HoTen = BanPhim.nextLine().trim();
            String SoDienThoai = BanPhim.nextLine().trim();
            int SoThuTuNhom = Integer.parseInt(BanPhim.nextLine().trim());
            DanhSachSinhVien.add(new SinhVien(MaSinhVien, HoTen, SoDienThoai, SoThuTuNhom));
        }

        String[] DanhSachBaiTap = new String[SoLuongNhom + 1];
        for (int ChiSo = 1; ChiSo <= SoLuongNhom; ChiSo++) {
            DanhSachBaiTap[ChiSo] = BanPhim.nextLine().trim();
        }

        int SoLuongTruyVan = Integer.parseInt(BanPhim.nextLine().trim());
        for (int ChiSo = 0; ChiSo < SoLuongTruyVan; ChiSo++) {
            int NhomTruyVan = Integer.parseInt(BanPhim.nextLine().trim());
            
            System.out.println("DANH SACH NHOM " + NhomTruyVan + ":");
            
            for (SinhVien DoiTuongSinhVien : DanhSachSinhVien) {
                if (DoiTuongSinhVien.SoThuTuNhom == NhomTruyVan) {
                    System.out.println(DoiTuongSinhVien.MaSinhVien + " " + 
                                       DoiTuongSinhVien.HoTen + " " + 
                                       DoiTuongSinhVien.SoDienThoai);
                }
            }
            
            System.out.println("Bai tap dang ky: " + DanhSachBaiTap[NhomTruyVan]);
        }
    }
}