// https://www.hackerrank.com/challenges/two-strings

/*
	Initial Solution - run through both the strings and check if any alphabet exists in the other string.
	
	Time Complexity - O(n^2)
	Space Complexity - O(1)
	
	Optimization 1 - check the smaller string with larger string
	
	Optimization 2 - create two boolean array for each string and check if that alphabet exists and save it in array
					if both alphabets are present in each boolean arrays than substring present and break the loop
	
	Time Complexity - O(N) - O(MAX(n1, n2))
	Space Complexity - O(1) - O(26 + 26)
*/

import java.util.Scanner;

class TwoStrings {
	
	static String twoStrings(String s1, String s2){
        // Complete this function
        int i = 0, j = 0;
        boolean substringFound = false;
        boolean[] arr1 = new boolean[26];
        boolean[] arr2 = new boolean[26];
        
        for(i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 97] = true;
        }
        
        for(i = 0; i < s2.length(); i++) {
            arr2[s2.charAt(i) - 97] = true;
        }
        
        for(i = 0; i < 26; i++) {
            if(arr1[i] && arr2[i]) {
                substringFound = true;
                break;
            }
        }
        
        return substringFound ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s1 = in.next();
            String s2 = in.next();
            String result = twoStrings(s1, s2);
            System.out.println(result);
        }
    }
	
}