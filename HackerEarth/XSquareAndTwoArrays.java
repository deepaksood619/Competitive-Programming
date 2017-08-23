// https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/xsquare-and-two-arrays/

/*

Question variables and there input taking and storing is kept out of complexity analysis

Time Complexity - O(R - L)*Q
Space Complexity - O(1) for storing ans

*/

import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        
        int[] A = new int[N];
        int[] B = new int[N];
        
        for(int i = 0; i < N; i++) {
            A[i] = in.nextInt();
        }
        for(int i = 0; i < N; i++) {
            B[i] = in.nextInt();
        }
        
        for(int i = 0; i < Q; i++) {
            int type = in.nextInt();
            int L = in.nextInt();
            int R = in.nextInt();
            
            long ans = 0;
            
            if(type == 1) {
                for(int j = L-1; j < R; j++) {
                    ans += A[j];
                    j++;
                    if(j < R) {
                        ans += B[j];
                    }
                }
            } else {
                for(int j = L-1; j < R; j++) {
                    ans += B[j];
                    j++;
                    if(j < R) {
                        ans += A[j];
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
