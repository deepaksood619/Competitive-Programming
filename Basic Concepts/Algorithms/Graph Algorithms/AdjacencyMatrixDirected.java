/* 
	Adjacency matrix for a directed graph
	v - vertex, e - edges
*/

import java.util.Scanner;

class AdjacencyMatrixDirected {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int i, j;
		
		int v = in.nextInt();
		int e = in.nextInt();
		
		int[][] matrix = new int[v][v];
		
		for(i = 0; i < v; i++) {
			matrix[i][i] = 1;
		}
		
		for(i = 0; i < v; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			
			matrix[m-1][n-1] = 1;
		}
		
		for(i = 0; i < v; i++) {
			for(j = 0; j < v; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}