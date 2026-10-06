
public class J01007 {
    private static long[] fib = new long[93];
    
    private static void precompute() {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= 92; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }
    
    private static boolean isFibonacci(long n) {
        int left = 0, right = 92;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (fib[mid] == n) return true;
            if (fib[mid] < n) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    private static long readLong() throws Exception {
        int c = System.in.read();
        while (c <= 32) {
            if (c == -1) return -1;
            c = System.in.read();
        }
        long res = 0;
        while (c > 32) {
            res = res * 10 + (c - '0');
            c = System.in.read();
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        precompute();
        
        int t = (int) readLong();
        if (t == -1) return;
         
        StringBuilder sb = new StringBuilder();
        
        while (t-- > 0) {
            long n = readLong();
            if (isFibonacci(n)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}

