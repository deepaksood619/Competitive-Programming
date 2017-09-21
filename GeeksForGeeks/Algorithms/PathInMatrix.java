// http://practice.geeksforgeeks.org/problems/path-in-matrix/0

/*

Using Dynamic Programming

Time complexity - O(M*N)

1
2
348 391 618 193

1
3
1 2 3 4 8 2 1 5 3
*/

import java.util.Scanner;

class PathInMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        while(T-- > 0) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            int[][] save = new int[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    arr[i][j] = in.nextInt();
                }
            }

            System.out.println(startMaxPath(arr, N, save));
        }
    }

    static int startMaxPath(int[][] arr, int N, int[][] save) {
        int max = 0;
        for(int i = 0; i < N; i++) {
            int val = maxPath(arr, 0, i, N, save);
            if(val > max) {
                max = val;
            }
        }
        return max;
    }

    static int maxPath(int[][] arr, int x, int y, int N, int[][] save) {
        if(x >= N || y>= N || y < 0) {
            return 0;
        } else if(x == N-1) {
            return arr[x][y];
        } else if(save[x][y] != 0) {
            return save[x][y];
        } else {
            save[x][y] = arr[x][y] + max(maxPath(arr, x+1, y-1, N, save), maxPath(arr, x+1, y, N, save), maxPath(arr, x+1, y+1, N, save));
            return save[x][y];
        }
    }

    static int max(int x, int y, int z) {
        if(x > y)
            return (x > z) ? x : z;
        else
            return (y > z) ? y : z;
    }
}