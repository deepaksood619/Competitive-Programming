// https://www.hackerrank.com/challenges/making-anagrams

/*
	Logic - count the number of each type of character present in each string,
			subtract the larger with smaller count to get the number of deletions.
			
	Space Complexity = O(26 + 26) = O(1)
						26 = to store the count of characters in 1st string
						26 = to store the count of characters in 2nd string
	
	Time Complexity = O(n1 + n2 + 26) = O(n), where n = length of string
						n1 = length of 1st string
						n2 = length of 2nd string
						26 = to iterate and get difference in both string each character count
*/

import java.util.Scanner;
import java.lang.Math.*;

class MakingAnagrams {
	
	static int makingAnagrams(String s1, String s2) {
		int[] countS1 = new int[26];
		int[] countS2 = new int[26];
		
		for(int i = 0; i < s1.length(); i++) {
			countS1[(int)s1.charAt(i) - 97]++;
		}
		
		for(int i = 0; i < s2.length(); i++) {
			countS2[(int)s2.charAt(i) -97]++;
		}
		
		int count = 0;
		for(int i = 0; i < 26; i++) {
			count += Math.abs(countS1[i] - countS2[i]);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s1 = in.next();
		String s2 = in.next();
		
		int result = makingAnagrams(s1, s2);
		System.out.println(result);
	}
}