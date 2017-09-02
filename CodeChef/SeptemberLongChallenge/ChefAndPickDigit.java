// https://www.codechef.com/SEPT17/problems/CHEFPDIG
// Problem code - CHEFPDIG

/*
Time Complexity - O(N) = N for couting sort + 26 for looping from 65 to 90
Space Complexity - O(1) = 10 ints for storing count of digits from 0 to 10

Test cases
4
65
566
11
1623455078
*/

import java.util.*;

class ChefAndPickDigit {

	public static void main (String[] args) {
		
		Scanner in = new Scanner(System.in);

		String strT = in.nextLine();

		int T = Integer.parseInt(strT);
		while(T-- > 0) {
			String strN = in.nextLine();

			int[] arr = new int[10];
			
			for(int i = 0; i < strN.length(); i++) {
				arr[strN.charAt(i) - 48]++;
			}

			for(int i = 65; i <= 90; i++) {
				int first = i/10;
				int second = i%10;
				if(first == second) {
					if(arr[first] > 1) {
						System.out.print((char)i);
					}
				} else {
					if(arr[first] > 0 && arr[second] > 0) {
						System.out.print((char)i);
					}
				}
			}
			System.out.println();
		}
		
		in.close();
	}
}