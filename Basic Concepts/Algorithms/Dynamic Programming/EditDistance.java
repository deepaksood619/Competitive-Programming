// http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

/*
Also called as Lavenshtein Distance
The Levenshtein distance, or edit distance, is the amount by which two strings differ.

Operations -
1. Insert (Addition)
2. Remove (Deletion)
3. Replace (Modification)

Algorithm -
// if either of the strings
// is empty
levd(i,j) = max(i,j)

// if the last character of
// both substrings match
// s1[i] == s2[j]
levd(i,j) = min(levd(i-1,j),
             levd(i,j-1),
             levd(i-1,j-1))

// in any other case
levd(i,j) = min(levd(i-1,j)+1,
             levd(i,j-1)+1,
             levd(i-1,j-1)+1)

Time Complexity - O(3^m) operations
The worst case happens when none of characters of two strings match.

Dynamic Programming - Use an auxillary array to store the computed values.
Overlapping Subproblems
 - Memoization (Top Down approach)
 - Tabulation (Bottom Up approach)
Optimal Substructure

Solved using Tabulation method (Bottom Up approach)

Time Complexity: O(m x n)
Auxiliary Space: O(m x n)

*/

class EditDistance {

    static int[][] arr;

    public static int min( int x, int y, int z ) {
        if ( x < y )
            return x < z ? x : z;
        else
            return y < z ? y : z;
    }

    public static int editDist( String str1, String str2, int m, int n ) {
        for(int i = 0; i <= m; i++) {
            for(int j = 0; j <= n; j++) {
                if(i==0)
                    arr[i][j] = j;

                else if(j == 0)
                    arr[i][j] = i;

                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    arr[i][j] = arr[i-1][j-1];

                else
                    arr[i][j] = 1 + min(arr[i-1][j], arr[i-1][j-1], arr[i][j-1]);
            }
        }
        return arr[m][n];
    }

    public static void main(String[] args) {
        String str1 = "sitting";
        String str2 = "kitten";

        arr = new int[str1.length() + 1][str2.length() + 1];
  
        System.out.println( editDist( str1 , str2 , str1.length(), str2.length()) );
    }
}