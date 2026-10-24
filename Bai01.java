import java.util.Scanner;
class NhanVien{
    String MaNV;
    String HoVaTen;
    String ChucVu;
    long PhuCapChucVu;
    long LuongCoBan;
    long LuongChinh;
    long TamUng;
    long ConLai;
    int SoNgayCong;

    public NhanVien(int id,String HoVaTen,String ChucVu,long LuongCoBan,int SoNgayCong) {
        this.MaNV=String.format("NV%02d",id);
        this.HoVaTen=HoVaTen;
        this.ChucVu=ChucVu;
        this.LuongCoBan=LuongCoBan;
        this.SoNgayCong=SoNgayCong;

        switch (ChucVu) {
            case "GD":
                this.PhuCapChucVu=500;
                break;
                
            case "PGD":
                this.PhuCapChucVu=400;
                break;

            case "TP":
                this.PhuCapChucVu=300;
                break;

            case "KT":
                this.PhuCapChucVu=250;
                break;
            default:
                this.PhuCapChucVu=100;
                break;
        }
        this.LuongChinh = LuongCoBan * SoNgayCong;
        double val = (double) (this.PhuCapChucVu + this.LuongChinh) * 2 / 3;
        if (val < 25000) {
            this.TamUng = Math.round(val / 1000.0) * 1000;
        } else {
        this.TamUng = 25000;
        }
        this.ConLai = this.LuongChinh + this.PhuCapChucVu - this.TamUng;
    }
}

public class Bai01{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        sc.nextLine();

        NhanVien[] ds = new NhanVien[n];
        for (int i = 0; i < n; i++) {
            String HoVaTen = sc.nextLine().trim();
            String ChucVu = sc.nextLine().trim();
            long LuongCoBan = sc.nextLong();
            int SoNgayCong = sc.nextInt();
            sc.nextLine();

            ds[i] = new NhanVien(i + 1, HoVaTen, ChucVu, LuongCoBan, SoNgayCong);
        }
        String targetChucVu = sc.nextLine().trim();
        for (int i = 0; i < n; i++) {
            if (ds[i].ChucVu.equals(targetChucVu)) {
                System.out.println(ds[i].MaNV + " " + ds[i].HoVaTen + " " + ds[i].PhuCapChucVu + " " +
                                    ds[i].LuongChinh + " " + ds[i].TamUng + " " + ds[i].ConLai);
            }
        }
    }
}
