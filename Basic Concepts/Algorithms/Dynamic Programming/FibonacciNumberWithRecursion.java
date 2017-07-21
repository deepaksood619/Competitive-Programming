// http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

/*
	In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of fibonacci series are 0 and 1.

There are two ways to write the fibonacci series program in java:

	1. Fibonacci Series without using recursion
	2. Fibonacci Series using recursion
	
	Starting element = 0
	
	Time Complexity - T(n) = T(n-1) + T(n-2) which is exponential.
	Space Complexity - O(n) if we consider the function call stack size, otherwise O(1).
*/

import java.util.Scanner;

class FibonacciNumberWithRecursion {
	
	static int fib(int count) {
		if(count <= 0) {
			return 0;
		} else if(count == 1) {
			return 1;
		}
		else {
			return fib(count - 1) + fib(count - 2);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter num of elements: ");
		int count = in.nextInt();
		System.out.println(fib(count));
		
	}
}