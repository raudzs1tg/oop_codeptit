public class Bai02 {
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int SoLanTest=scanner.nextInt();
        if (SoLanTest>0 && SoLanTest<=10){
            for(int i=0 ; i<SoLanTest ; i++){
                long N=scanner.nextInt();
                long tong=N*(N+1)/2;
                System.out.println(tong);
            }
        }
    }
}
