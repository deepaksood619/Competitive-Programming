// https://www.hackerrank.com/challenges/fibonacci-modified

/*
	Time Complexity - O(N)
	Space Complexity - O(1)
*/

import java.util.Scanner;
import java.math.BigInteger;

class FibonacciModified {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t1 = in.nextInt();
		int t2 = in.nextInt();
		
		int n = in.nextInt();
		
		BigInteger fib0 = BigInteger.valueOf(t1);
		BigInteger fib1 = BigInteger.valueOf(t2);
		BigInteger fib2 = null;
		
		for(int i = 0; i < n-2; i++) {
			fib2 = fib0.add(fib1.multiply(fib1));
			
			fib0 = fib1;
			fib1 = fib2;
		}
		
		System.out.println(fib2);
	}
	
}