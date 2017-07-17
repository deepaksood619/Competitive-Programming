// https://www.hackerrank.com/challenges/gem-stones

/*
	Initial Thought - create an array representing 26 alphabets,
						increment for each unique character and
						if the number of characters are equal to number of string
						then its a gem element
						
	Second Thought - Question if ambiguous, what if there are 2 same gem element present
						in each rock, if that is the case then we should create 3 arrays,
						each representing one rock.

Input - 						
3
abcdde
baccd
eeabg

*/

import java.util.Scanner;

class Gemstones {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		
		int[][] countArr = new int[N][26];
		
		for(int j = 0; j < N; j++) {
			String input = in.next();
			
			int inputLen = input.length();
			
			for(int i = 0; i < inputLen; i++) {
				int index = (int)input.charAt(i) - 97;
				
				countArr[j][index]++;
			}
		}
		
		int numOfGems = 0;

		for(int i = 0; i < 26; i++) {
			int min = 101;
			for(int j = 0; j < N; j++) {
				if(countArr[j][i] < min) {
					min = countArr[j][i];
				}
			}
			numOfGems += min;
		}
		
		System.out.println(numOfGems);
	}
}