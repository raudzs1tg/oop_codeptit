import java.util.Scanner;
public class J01001{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        if(sc.hasNextInt()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if (a>=0 ||b>=0){
                System.out.println(0);
            }else{
                long chuVi=(a+b)*2;
                long dienTich=a*b;
                System.out.println(chuVi+" "+dienTich);
            }
        sc.close();
        }
    }
}
