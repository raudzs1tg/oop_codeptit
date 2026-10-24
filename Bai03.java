import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class GiangVien {
    String maGV;
    String tenGV;
    double tongGio;

    public GiangVien(String maGV, String tenGV) {
        this.maGV = maGV;
        this.tenGV = tenGV;
        this.tongGio = 0;
    }
}

public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            sc.nextLine();
        }

        int m = sc.nextInt();
        sc.nextLine();
        
        ArrayList<GiangVien> dsGV = new ArrayList<>();
        HashMap<String, GiangVien> mapGV = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split("\\s+", 2);
            String maGV = parts[0];
            String tenGV = parts[1];
            
            GiangVien gv = new GiangVien(maGV, tenGV);
            dsGV.add(gv);
            mapGV.put(maGV, gv);
        }

        int k = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < k; i++) {
            String maGV = sc.next();
            String maMH = sc.next();
            double gio = sc.nextDouble();
            sc.nextLine(); 

            if (mapGV.containsKey(maGV)) {
                mapGV.get(maGV).tongGio += gio;
            }
        }

        for (GiangVien gv : dsGV) {
            System.out.printf("%s %.2f\n", gv.tenGV, gv.tongGio);
        }
    }
}