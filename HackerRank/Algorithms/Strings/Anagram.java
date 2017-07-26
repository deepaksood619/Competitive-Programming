// https://www.hackerrank.com/challenges/anagram

/*
	Used counting sort to get count of each alphabet,
	
	Time Complexity - O(n) - O(n) for parsing and counting string and then O(26) for get the count from the array
	Space Complexity - O(1) - O(26 + 26) for storing the count of alphabets.
*/

import java.util.Scanner;

class Anagram {
	
	public static int countAnagramDiff(String s) {
		if(s.length() % 2 == 0) {
			
			int half = s.length()/2;
			int[] stringArr1 = new int[26];
			int[] stringArr2 = new int[26];
			
			for(int i = 0; i < half; i++) {
				stringArr1[s.charAt(i) - 97]++;
			}
			for(int i = half; i < s.length(); i++) {
				stringArr2[s.charAt(i) - 97]++;
			}
			
			/*
			for(int i = 0; i < 26; i++) {
				System.out.print(" " + stringArr1[i]);
			}
			System.out.println();
			for(int i = 0; i < 26; i++) {
				System.out.print(" " + stringArr2[i]);
			}
			*/
			
			int count = 0;
			for(int i = 0; i < 26; i++) {
				if(stringArr1[i] > stringArr2[i]) {
					count += stringArr1[i] - stringArr2[i];
				}
			}
			
			return count;
		} else {
			return -1;			
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		while(T-- > 0) {
			String input = in.next();
			
			//System.out.println();
			System.out.println(countAnagramDiff(input));
		}
	}
}