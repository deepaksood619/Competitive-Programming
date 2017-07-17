// http://practice.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not/0

import java.util.Scanner;

class SumOfDigitIsPalindromeOrNot {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		/*for(int i = 0; i < T; i++) {
			int sum = 0;
			String input = in.next();
			for(int j = 0; j < input.length(); j++) {
				sum += Character.getNumericValue(input.charAt(j));
			}
			
			String palindrome = Integer.toString(sum);
			
			boolean isPalindrome = true;
			for(int k = 0; k < palindrome.length()/2; k++) {
				if(palindrome.charAt(k) != palindrome.charAt(palindrome.length() - k - 1)) {
					isPalindrome = false;
				}
			}
			
			if(isPalindrome) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}*/
		
		// optimized - removed the conversion from every char to int while adding the digits of input String
		
		while(T-- > 0) {
			int input = in.nextInt();
			int sum = 0;
			while(input > 0) {
				sum += input%10;
				input = input / 10;
			}
			
			String palindrome = Integer.toString(sum);
			
			boolean isPalindrome = true;
			for(int k = 0; k < palindrome.length()/2; k++) {
				if(palindrome.charAt(k) != palindrome.charAt(palindrome.length() - k - 1)) {
					isPalindrome = false;
				}
			}
			
			String output = isPalindrome ? "YES" : "NO";
			
			System.out.println(output);
		}
	}
}