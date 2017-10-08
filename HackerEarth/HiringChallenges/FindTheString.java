/*
0-9 = 48-57
A-Z = 65-90
a-z = 97-122
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class FindTheString {

    public static boolean canGenerateString(String[] matrix, int n, int m, String s) {

        int[][] count = new int[n][26];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                count[i][matrix[i].charAt(j)-97]++;
            }
        }

        int len = s.length();
        for(int i = 0; i < len; i++) {
            int v1 = i%n;
            int v2 = s.charAt(i)-97;
            // System.out.println("v1 - " + v1 + " v2 - " + v2 + " count - " + count[v1][v2]);
            if(count[v1][v2] > 0) {
                --count[v1][v2];
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        while(T-- > 0) {
            String foo = br.readLine().trim();
            String[] fooArr = foo.split(" ");
            int n = Integer.parseInt(fooArr[0]);
            int m = Integer.parseInt(fooArr[1]);

            String[] matrix = new String[n];

            for(int i = 0; i < n; i++) {
                matrix[i] = br.readLine().trim();
            }

            String s = br.readLine().trim();

            if(canGenerateString(matrix, n, m, s)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}