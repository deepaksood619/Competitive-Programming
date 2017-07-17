// https://www.hackerrank.com/challenges/the-love-letter-mystery

/*
	Also can use Math.abs(first - second) to calculate the difference
	without checking for less than or greater than
	and only checking !=
	if(first != second)
		steps += Math.abs(first - second);
*/

import java.util.Scanner;

class TheLoveLetterMystery {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while(T-- > 0) {
			String input = in.next();
			
			int len = input.length();
			int steps = 0;
			
			for(int i = 0; i < len/2; i++) {
				
				int first = (int) input.charAt(i);
				int second = (int) input.charAt(len - i - 1);
				
				if(first < second) {
					steps += second - first;
				} else if(first > second) {
					steps += first - second;
				}
			}
			
			System.out.println(steps);
		}
	}
}