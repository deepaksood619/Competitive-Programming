// http://practice.geeksforgeeks.org/problems/edit-distance/0

/*
Using Dynamic Programming memoization

Time Complexity - O(m*n)
Space Complexity - O(m*n)

2
4 5
geek gesek
6 8
sunday saturday

1
7 6
sitting kitten
*/

import java.util.Scanner;

class EditDistance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-- > 0) {
            int P = in.nextInt();
            int Q = in.nextInt();
            in.nextLine();
            String line = in.nextLine();
            String[] splitLine = line.split(" ");
            String str1 = splitLine[0];
            String str2 = splitLine[1];

            int[][] tab = new int[P+1][Q+1];

            System.out.println(editDistance(str1, str2, P, Q, tab));
        }
    }

    static int editDistance(String str1, String str2, int i, int j, int[][] tab) {
        for (int m = 0; m <= i; m++) {
            for (int n = 0; n <= j; n++) {
                if (m == 0)
                    tab[m][n] = n;
                else if (n == 0)
                    tab[m][n] = m;
                else if (str1.charAt(m-1) == str2.charAt(n-1))
                    tab[m][n] = tab[m-1][n-1];
                else
                    tab[m][n] = 1 + min(tab[m][n-1], tab[m-1][n], tab[m-1][n-1]);
            }
        }
        return tab[i][j];
    }

    static int min(int x, int y, int z) {
        if(x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }
}