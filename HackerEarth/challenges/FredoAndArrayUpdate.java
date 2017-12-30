// https://www.hackerearth.com/challenge/test/programming-practice-challenge/algorithm/38fe887021c8434ca51f5046912b51e9/

/*
	Time Complexity - O(1)
	Space Complexity - O(1)
*/

import java.util.Scanner;

class FredoAndArrayUpdate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			sum += in.nextInt();
		}
		
		int ans = (int)(sum/N) + 1;
		
		System.out.println(ans);
	}
}