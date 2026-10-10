public class Bai01 {
    public static void main(String[] args){
        java.util.Scanner scanner= new java.util.Scanner(System.in);
        int ChieuDai=scanner.nextInt();
        int ChieuRong=scanner.nextInt();
        if (ChieuDai<=0 || ChieuRong<=0){
            System.out.println("0");
        }
        else{
            long ChuVi= (long) (ChieuDai + ChieuRong)*2;
            long DienTich= (long) ChieuDai * ChieuRong;
            System.out.println(ChuVi +" "+ DienTich);
        }
    }
}
