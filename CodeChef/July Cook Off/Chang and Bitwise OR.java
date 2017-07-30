// https://www.codechef.com/COOK84/problems/CHNGOR

/*
	Problem Code: CHNGOR
*/

import java.util.Scanner;

class CHNGOR {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T-- > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];
			
			int sum = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			System.out.println("sum - " + sum);
			for(int i = 0; i < N-1; i++) {
				int foo = 0;
				for(int j = 0; j < N-1; j++) {
					foo += arr[i] | arr[j];
				}
				if(foo < sum) {
					sum = foo;
				}
			}
			System.out.println(sum);
		}
	}
}