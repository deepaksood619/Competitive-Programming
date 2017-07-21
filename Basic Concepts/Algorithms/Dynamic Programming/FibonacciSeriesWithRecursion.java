/*
	In fibonacci series, next number is the sum of previous two numbers for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc. The first two numbers of fibonacci series are 0 and 1.

There are two ways to write the fibonacci series program in java:

	1. Fibonacci Series without using recursion
	2. Fibonacci Series using recursion
	
	Starting element = 0
*/

import java.util.Scanner;

class FibonacciSeriesWithRecursion {
	
	static int n1 = 0, n2 = 1, n3;
	
	static void printFibonacci(int count) {
		if(count > 0) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" " + n3);
			printFibonacci(count - 1);
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter num of elements: ");
		System.out.println();
		int count = in.nextInt();
		if(count <= 1) {
			System.out.println("0");
		}
		if(count >= 2) {
			System.out.print(n1 + " " + n2);
			printFibonacci(count - 2);
		}
		
	}
}