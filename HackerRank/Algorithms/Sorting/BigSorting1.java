// https://www.hackerrank.com/challenges/big-sorting
// Solution - https://github.com/RyanFehr/HackerRank/blob/master/Algorithms/Sorting/Big%20Sorting/Solution.java

import java.util.*;

public class BigSorting1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int i = 0; i < n; i++) unsorted[i] = in.next();

        Arrays.sort(unsorted,new Comparator<String>() {
            @Override
            public int compare(String a, String b) 
            {
                return StringAsIntegerCompare(a,b);
            }
        });
        
        StringBuilder output = new StringBuilder("");
        for(String num : unsorted)
            output.append(num+"\n");
        System.out.println(output);
    }
    
    //0 means s1=s2, 1 means s1>s2, -1 means s1<s2 
    static int StringAsIntegerCompare(String s1, String s2)
    {
        if(s1.length() > s2.length()) return 1;
        if(s1.length() < s2.length()) return -1;
        for(int i = 0; i < s1.length(); i++)
        {
            if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
            if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
        }
        return 0;
	}
}
		
		