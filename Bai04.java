public class Bai04 {
    public static void main(String[] args){
        java.util.Scanner scanner=new java.util.Scanner(System.in);
        if (scanner.hasNextInt()){
            int SoBoTest=scanner.nextInt();
            for (int test=1;test<=SoBoTest;test++){
                int n=scanner.nextInt();
                int[]a=new int[n];
                int[]dem=new int[10000];
                for (int i=0;i<n;i++){
                    a[i]=scanner.nextInt();
                    dem[a[i]]++;
                }
                System.out.println("Test " + test + ":");
                for(int i=0;i<n;i++){
                    if(dem[a[i]]>0){
                        System.out.println(a[i] + " xuat hien " + dem[a[i]] + " lan" );
                        dem[a[i]]=0;
                    }
                }
            }
        }
        
    }
}
