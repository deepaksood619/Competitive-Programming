// https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/crazy-matrix/

import java.util.*;

/*
4
0 0 0 1
2 0 1 0
0 2 1 2
0 1 2 0
*/

class CrazyMatrix {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        boolean flag1 = false, flag2 = false;

        for(int j = 0; j < N; j++) {
            if(arr[0][j] == 1) {
                boolean visited[][] = new boolean[N][N];
                flag1 = dfs(arr, 0, j, 1, N, visited);
                if(flag1)
                    break;
            }
        }

        for(int i = 0; i < N; i++) {
            if(arr[i][0] == 2) {
                boolean[][] visited = new boolean[N][N];
                flag2 = dfs(arr, i, 0, 2, N, visited);
                if(flag2)
                    break;
            }
        }

        if(flag1 && flag2)
            System.out.println("AMBIGUOUS");
        else if(flag1) {
            System.out.println("1");
        } else if(flag2) {
            System.out.println("2");
        } else {
            System.out.println("0");
        }
    }

    static boolean dfs(int[][] arr, int i, int j, int flag, int N, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= N || j >= N) 
            return false;

        if(arr[i][j] != flag || visited[i][j])
            return false;
        
        if(i == N-1 && flag == 1) 
            return true;

        if(j == N-1 && flag == 2)
            return true;

        visited[i][j] = true;

        if(dfs(arr, i-1, j-1, flag, N, visited)) return true;
        if(dfs(arr, i, j-1, flag, N, visited)) return true;
        if(dfs(arr, i+1, j-1, flag, N, visited)) return true;
        if(dfs(arr, i+1, j, flag, N, visited)) return true;
        if(dfs(arr, i+1, j+1, flag, N, visited)) return true;
        if(dfs(arr, i, j+1, flag, N, visited)) return true;
        if(dfs(arr, i-1, j+1, flag, N, visited)) return true;

        return false;
    }
}