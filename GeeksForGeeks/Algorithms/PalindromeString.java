// http://practice.geeksforgeeks.org/problems/palindrome-string/0

/*
	1. one solution is to check from end and front and compare characters till middle
	2. second solution is to reverse the string and compare the reversed and orginal string
*/

import java.util.Scanner;

class PalindromeString {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		while(t-- > 0) {
			int len = in.nextInt();
			
			String input = in.next();
			boolean isPalindrome = true;
			
			for(int i = 0; i < len/2; i++) {
				if(input.charAt(i) != input.charAt(len - i - 1)) {
					isPalindrome = false;
				}
			}
			
			String out = isPalindrome ? "Yes" : "No";
			System.out.println(out);
		}
	}
}