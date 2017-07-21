// http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

/*
	In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of fibonacci series are 0 and 1.

There are two ways to write the fibonacci series program in java:

	1. Fibonacci Series without using recursion
	2. Fibonacci Series using recursion
	
	improvement on the FibonacciNumberDP in terms of space complexity, 
	since we only need the last two numbers for generating the next number,
	we store only last two values.
	
	Time Complexity - O(n)
	Space Complexity - O(1)
*/

import java.util.Scanner;

class FibonacciSeriesWithoutRecursion {
	
	static int fib(int n) {
		int n1 = 0, n2 = 1, n3;
		if(n == 0) {
			return n1;
		}
		// for printing the series
		System.out.print(n2);
		
		for(int i = 2; i <= n; i++) {		
			n3 = n1 + n2;
			System.out.print(" " + n3);
			n1 = n2;
			n2 = n3;
		}
		return n2;
	}

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter num of elements to see in fibonacci series -");
		int num = in.nextInt();
		
		/* for printing only the nth number */
		//System.out.println(fib(num));
		
		/* for printing all the number in series */
		fib(num);
	}
}