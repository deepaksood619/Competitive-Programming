// https://www.codechef.com/SEPT17/problems/CHEFSUM
// Problem Code - CHEFSUM

/*
Time Complexity - 3*N = O(N)
Space Complexity - 2*N = O(N)
*/

import java.util.*;

class LittleChefAndSums {

	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while(T-- > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			long min = Long.MAX_VALUE;
            int index = 0;
            long[] pArr = new long[N];
            long[] sArr = new long[N];

            pArr[0] = arr[0];
            for(int i = 1; i < N; i++) {
                pArr[i] = pArr[i-1] + arr[i];
            }

            sArr[N-1] = arr[N-1];
            for(int i = N-2; i >= 0; i--) {
                sArr[i] = sArr[i+1] + arr[i];
            }

            long val;
            for(int i = 0; i < N; i++) {
                val = pArr[i] + sArr[i];
                if(val < min) {
                    min = val;
                    index = i+1;
                }
            }

			System.out.println(index);

		}
		
		in.close();
	}
}

/*
1st solution -
Time complexity - O(N^2);
Space Complexity - O(1)

int min = Integer.MAX_VALUE;
			int index = 0;
			for(int i = 0; i < N; i++) {

				int prefixSum = 0;
				for(int j = 0; j <= i; j++) {
					prefixSum += arr[j];
				}

				int suffixSum = 0;
				for(int j = N; j >= i; j--) {
					suffixSum += arr[j];
				}

				int sum = prefixSum + suffixSum;
				if(sum < min) {
					min = sum;
					index = i+1;
				}
			}

            System.out.println(index);


2nd Solution-
Time Complexity - 3*N = O(N)
Space Complexity - 2*N = O(N)

long min = Long.MAX_VALUE;
            int index = 0;
            long[] pArr = new long[N];
            long[] sArr = new long[N];

            pArr[0] = arr[0];
            for(int i = 1; i < N; i++) {
                pArr[i] = pArr[i-1] + arr[i];
            }

            sArr[N-1] = arr[N-1];
            for(int i = N-2; i >= 0; i--) {
                sArr[i] = sArr[i+1] + arr[i];
            }

            long val;
            for(int i = 0; i < N; i++) {
                val = pArr[i] + sArr[i];
                if(val < min) {
                    min = val;
                    index = i+1;
                }
            }

            System.out.println(index);
            
3rd solution
**Not worked for 1st and 2nd test cases, but worked for 3rd test case
Time Complexity - 2*N = O(N)
Space Complexity - 1*N = O(N)

long[] pArr = new long[N];

            pArr[0] = arr[0];
            for(int i = 1; i < N; i++) {
                pArr[i] = pArr[i-1] + arr[i];
            }

            long val = 0;
            long last = arr[N-1];
            long min = pArr[N-1] + last;
            int index = N;
            long sum;

            for(int i = N-2; i >= 0; i--) {
                val = last + arr[i];
                last = val;

                sum = val + pArr[i];
                if(sum <= min) {
                    min = sum;
                    index = i;
                }
            }

            index++;
			System.out.println(index);
            
*/