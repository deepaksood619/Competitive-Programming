// https://www.codechef.com/COOK84/problems/CHNGFUNC
/* 
Problem Code: CHNGFUNC
*/

import java.util.Scanner;
import java.math.*;

class CHNGFUNC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		
		int count = 0;
		
		for(int i = 1; i <= A; i++) {
			for(int j = 1; j <= B; j++) {
				
				if(isPerfectSquare(Math.pow(i, 2) + j)) {
					count++;
				}
			}
		}
		
		System.out.print(count);
	}
	
	static boolean isPerfectSquare(double val) {
		double foo = Math.sqrt(val);
		int bar = (int) foo;
		return val == bar * bar;
	}
}