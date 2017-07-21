// http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

/*
	We can avoid the repeated work done is the method 1 by storing the Fibonacci numbers calculated so far.
	
	Time Complexity - O(n)
	Space Complexity - O(n)
*/

import java.util.Scanner;

class FibonacciNumberDP {
	
	static int fib(int n) {
		
		/* Declare an array to store Fibonacci numbers. */
		int[] f = new int[n + 1];
		int i;
		f[0] = 0;
		f[1] = 1;
		
		for(i = 2; i <= n; i++) {
			/* Add the previous 2 numbers in the series
				and store it */
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter num - ");
		int count = in.nextInt();
		
		System.out.println(fib(count));
	}
}