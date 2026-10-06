public class J01013 {
    private static final int MAX_VAL = 2000005;
    
    private static int[] minPrime = new int[MAX_VAL];

    private static void sieve() {
        for (int i = 2; i < MAX_VAL; i++) {
            minPrime[i] = i;
        }
        
        for (int i = 2; i * i < MAX_VAL; i++) {
            if (minPrime[i] == i) {
                for (int j = i * i; j < MAX_VAL; j += i) {
                    if (minPrime[j] == j) {
                        minPrime[j] = i;
                    }
                }
            }
        }
    }

    private static int readInt() throws Exception {
        int c = System.in.read();
        while (c <= 32) {
            if (c == -1) return -1;
            c = System.in.read();
        }
        int res = 0;
        while (c > 32) {
            res = res * 10 + (c - '0');
            c = System.in.read();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        sieve();
        
        int n = readInt();
        if (n == -1) return;
        
        long totalSum = 0; 
        
        for (int i = 0; i < n; i++) {
            int num = readInt();
            
            while (num > 1) {
                totalSum += minPrime[num];
                num /= minPrime[num];
            }
        }
        
        System.out.println(totalSum);
    }
}

