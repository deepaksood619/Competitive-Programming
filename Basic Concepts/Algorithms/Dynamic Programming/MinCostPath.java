// http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

/*
    Time Complexity - O(mn)
*/

class MinCostPath {
    public static void main(String[] args) {
        int[][] cost = new int[][] {{1,2,3},{4,8,2},{1,5,3}};
        int[][] minCostArr = new int[3][3];

        System.out.println(minCost(cost, minCostArr, 2, 2));
    }

    static int minCost(int[][] cost, int[][] minCostArr, int x, int y) {
        if(x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        } else if(x == 0 && y == 0) {
            return cost[x][y];
        } else if(minCostArr[x][y] != 0) {
            return minCostArr[x][y];
        } else {
            minCostArr[x][y] = cost[x][y] + min(minCost(cost, minCostArr, x-1, y), minCost(cost, minCostArr, x, y-1), minCost(cost, minCostArr, x-1, y-1));
            return minCostArr[x][y];
        }
    }

    static int min(int x, int y, int z) {
        if(x < y)
            return (x < z) ? x : z;
        else 
            return (y < z) ? y : z;
    }
}