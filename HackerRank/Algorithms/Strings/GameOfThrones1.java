// https://www.hackerrank.com/challenges/game-of-thrones

/*
	0 - 9 = 48 - 57
	A - Z = 65 - 90
	a - z = 97 - 122
	Initial Thought - Since the max length of string can be 10^5 which is large,
						Count the characters and use counting sort techinque to find
						all the characters numbers
						Now, if every character is even then the string's anagram is palindrome
						or if every character is even number and only one is 1, then also the string's anagram is palindrome
						
	Time Complexity - O(n), n for parsing the string + 26 for parsing the countArr
	Space Complexity - O(1) for arr of size 26
*/

import java.util.Scanner;

class GameOfThrones1 {
	
	public static boolean checkPalindrome(int[] countArr) {
		boolean palindrome = true;
		for(int i = 0; i < 26; i++) {
			if(countArr[i] % 2 == 1) {
				
				if(!palindrome) {
					return false;
				}
				palindrome = false;
				
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.next();
		
		int len = s.length();
		int[] countArr = new int[26];
		
		for(int i = 0; i < len; i++) {
			countArr[s.charAt(i) - 97]++;
		}
		
		String ans = checkPalindrome(countArr) ? "YES" : "NO";
		System.out.println(ans);
	}
}