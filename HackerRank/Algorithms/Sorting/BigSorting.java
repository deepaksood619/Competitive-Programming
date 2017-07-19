// https://www.hackerrank.com/challenges/big-sorting/problem

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

class BigSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		
		String[] unsorted = new String[n];
		
		for(int i = 0; i < n; i++) {
			unsorted[i] = in.next();
		}
		
		Arrays.sort(unsorted, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return StringAsIntegerCompare(a, b);
			}
		});
		
		for(int i = 0; i < n; i++) {
			System.out.println(unsorted[i]);
		}
	}
	
	static int StringAsIntegerCompare(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return 1;
		}
		if(s1.length() < s2.length()) {
			return -1;
		}
		for(int i = 0; i < s1.length(); i++) {
			if((int)s1.charAt(i) > (int)s2.charAt(i)) {
				return 1;
			}
			if((int)s1.charAt(i) < (int)s2.charAt(i)) {
				return -1;
			}
		}
		return 0;
	}
}