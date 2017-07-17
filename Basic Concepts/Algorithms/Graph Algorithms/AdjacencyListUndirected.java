/*
	Adjacency list for undirected graph
	v - vertex, e - edge
*/

import java.util.Scanner;
import java.util.ArrayList;

class AdjacencyListUndirected {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int v = in.nextInt();
		int e = in.nextInt();
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		
		for( int i = 0; i < v; i++) {
			ArrayList<Integer> arrList = new ArrayList<>();
			arr.add(arrList);
		}
		
		for(int i = 0; i < e; i++) {
			int m = in.nextInt();
			int n = in.nextInt();
			
			ArrayList<Integer> arrList  = arr.get(m);
			arrList.add(n);
			arr.set(m, arrList);
			
			ArrayList<Integer> arrListReverse = arr.get(n);
			arrListReverse.add(m);
			arr.set(n, arrListReverse);
		}
		
		int k = 0;
		for(ArrayList<Integer> list : arr) {
			System.out.print(k + " - ");
			for(Integer item : list) {
				System.out.print(item + " ");
			}
			System.out.println();
			k++;
		}
	}
}