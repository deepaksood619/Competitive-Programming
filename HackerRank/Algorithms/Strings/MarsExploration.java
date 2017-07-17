// https://www.hackerrank.com/challenges/mars-exploration

import java.util.Scanner;

class MarsExploration {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String input = in.next();
		
		int altered = 0;
		for(int i = 0; i < input.length(); i++) {
			
			if((i-1)%3 == 0) {
				if(input.charAt(i) != 'O') {
					altered++;
				}
			} else {
				if(input.charAt(i) != 'S') {
					altered++;
				}
			}
			
		}
		
		System.out.println(altered);
	}
}