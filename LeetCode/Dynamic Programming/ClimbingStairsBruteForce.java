// Problem - https://leetcode.com/problems/climbing-stairs/
// Solution - https://leetcode.com/problems/climbing-stairs/#/solution

import java.util.Scanner;

class ClimbingStairsBruteForce {
	
	static int n1 = 0, n2 = 1, n3;
	
	static void recurseFibonacciSeries(int count) {
		if(count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			recurseFibonacciSeries(count - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter n - ");
		int n = in.nextInt();
		
		System.out.print(n1 + " " + n2);
		recurseFibonacciSeries(n-2);
	}	
}