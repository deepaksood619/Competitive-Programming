// https://www.topcoder.com/community/data-science/data-science-tutorials/an-introduction-to-recursion-part-1/
// https://www.topcoder.com/community/data-science/data-science-tutorials/an-introduction-to-recursion-part-2/

class RecusionBasic {

    static int N;

    public static void main(String[] args) {
        
        N = 4;
        int[][] arr = new int[][] {{-1, 0, 0, 1}, {0, 0, -1, 0}, {0, -1, 0, 0}, {2, 0, -1, 0}};
        boolean[][] visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

        // we have to find if we can reach from 1 to 2
        // visited[0][3] = true;
        System.out.println(checkPath(arr, visited, 0, 3));

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }

    }

    static boolean checkPath(int[][] arr, boolean[][] visited, int i , int j) {
        if(i < N && j < N && i > -1 && j > -1) {
            System.out.println("i - " + i + " j - " + j);
            if(arr[i][j] == 2) {
                return true;
            }

            if(arr[i][j] == -1) {
                visited[i][j] = true;
                return false;
            }

            // check for visited
            if(!visited[i][j]) {
                visited[i][j] = true;
                System.out.println("Visit - i - " + i + " j - " + j);
                if(checkPath(arr, visited, i-1, j)) return true;
                if(checkPath(arr, visited, i+1, j)) return true;
                if(checkPath(arr, visited, i, j-1)) return true;
                if(checkPath(arr, visited, i, j+1)) return true;
            }
        }
        return false;
    }
}