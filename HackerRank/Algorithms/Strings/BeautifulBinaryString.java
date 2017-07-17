// https://www.hackerrank.com/challenges/beautiful-binary-string

/*
First Solution - Replace all 010 substring with special character
				and count the number of special characters;
				
Second Solution - Split the string with delimeter 010 and count number of partitions;

Third Solution - read character one by one and check if we get the substring 010

Fourth Solution - using replaceAll
*/

import java.util.Scanner;

public class BeautifulBinaryString {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		
		String input = scanner.next();
		
		System.out.println((input.length() - input.replaceAll("010", "").length())/3);
	}
}