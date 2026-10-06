import java.util.Scanner;

public class J01001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            if (a <= 0 || b <= 0) {
                System.out.println(0);
            } else {
                int chuVi = (a + b) * 2;
                int dienTich = a * b;
                System.out.println(chuVi + " " + dienTich);
            }
        }
        
        scanner.close();
    }
}
    

