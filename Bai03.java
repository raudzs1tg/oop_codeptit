public class Bai03 {
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        if (scanner.hasNextInt()){
            int N=scanner.nextInt();
            int K=scanner.nextInt();
            int[]a=new int[K+1];
            for(int i=1;i<=K;i++){
                a[i]=i;
            }
            int TongSoToHop=0;
            boolean ToHopCuoiCung=false;
            while (ToHopCuoiCung==false) {
                for(int i=1;i<=K;i++){
                    System.out.print(a[i] + " ");
                }
                System.out.println();
                TongSoToHop++;

                int i=K;
                while (i>0 && a[i]==N-K+i) {
                    i--;                    
                }

                if(i>0){
                    a[i]=a[i]+1;
                    for(int j=i+1;j<=K;j++){
                        a[j]=a[j-1]+1;
                    }
                }
                else{
                    ToHopCuoiCung=true;
                }    
            }
            System.out.println("Tong cong co " + TongSoToHop + " to hop");
        }

    }
}
