// https://www.hackerearth.com/problem/algorithm/roy-and-wobbly-numbers/description/

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        
        int[] arr = new int[81];
        int a = 1;
        int b;
        int i = 0;
        while(a < 10) {
            b = 0;
            while(b < 10) {
                if(a != b) {
                    arr[i++] = a*10 + b;
                }
                b++;
            }
            a++;
        }
        
        int T = in.nextInt();
        while(T-- > 0) {
            int N = in.nextInt();
            int K = in.nextInt();
            
            if(K > 81) {
                System.out.print("-1");
            } else {
                int val = arr[K-1];
                while(N >= 2) {
                    System.out.print(val);
                    N = N - 2;
                    if(N == 1) {
                        System.out.print(val / 10);
                    }
                }
            }
            System.out.println();
        }
        
    }
}
