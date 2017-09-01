// https://www.codechef.com/SEPT17/problems/MINPERM
// Problem code - MINPERM

/*
Time Complexity - O(N)
Space Complexity - O(1)
*/

import java.util.*;

class MinimumGoodPermutation {

	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while(T-- > 0) {
			int n = in.nextInt();
			
			if(n % 2 == 0) {
				// even
				int i = 2;
				while(i <= n) {
					System.out.print(i + " " + (i-1));
					i += 2;
					if(i <= n) {
						System.out.print(" ");
					}
				}
			} else {
				// odd
				int i = 2;
				while(i <= n-3) {
					System.out.print(i + " " + (i-1) + " ");
					i += 2;
				}
				System.out.print(i + " " + (i+1) + " " + (i-1));
			}
			System.out.println();

		}
		
		in.close();
	}
}