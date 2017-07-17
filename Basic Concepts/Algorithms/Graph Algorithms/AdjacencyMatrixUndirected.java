/*
	AdjacencyMatrix for un undirected graph
	v = number of vertices
	e = number of edges
	3 3 (v,e)
	1 2 (e1, e2)
	2 3 (e1, e2)
	3 1 (e1, e2)
	
*/

import java.util.Scanner;

class AdjacencyMatrixUndirected {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int v = in.nextInt();
		int e = in.nextInt();
		
		int[][] matrix = new int[v][v];
		for(int i = 0; i < v; i++) {
			matrix[i][i] = 1;
		}
		
		for(int i = 0; i < e; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			
			matrix[m-1][n-1] = 1;
			matrix[n-1][m-1] = 1;
		}
		
		for(int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}