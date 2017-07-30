// http://www.geeksforgeeks.org/c-program-factorial-number/

/*
	Time Complexity - O(n)
*/

import java.util.Scanner;

class Factorial {
	
	static int fact(int n) {
		if(n == 1) {
			return 1;
		}
		return n * fact(n - 1);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		Factorial factorial = new Factorial();
		System.out.println(factorial.fact(n));
	}
}