// https://www.hackerrank.com/challenges/torque-and-development

/*
	Concept - if cLib <= cRoad, then simply create library at each vertex and return the cost.
				if cLib > cRoad, then create library in each connected components and
				then find the minimum number of edges, multiply it with the cost of road (cRoad)
				and return the sum.
				
				minimum number of edges in a connected graph = numOfVertices - 1
				
				for connectedComponents and numOfVertices BFS is used
				
	Equation - for each component (cLib + cRoad * (numOfVertices - 1))
	
	SpaceComplexity - O(|V|), since at worst case we need to hold all vertices in the queue.
	
	TimeComplexity - O(|V|) where |V| is the number of nodes, we need to traverse all nodes. 
*/

import java.util.Scanner;
import java.util.LinkedList;

class RoadsAndLibraries {
	
	static long connectedComponents(boolean[] visited1, LinkedList<Integer>[] arrList1, long cLib1, long cRoad1) {
		int numOfComponents = 0;
		long sum = 0;
		
		for(int i = 0; i < visited1.length; i++) {
			if(!visited1[i]) {
				int numOfVertices = bfs(i, visited1, arrList1);
				sum += cLib1 + (cRoad1 * (numOfVertices - 1));
			}
		}
		return sum;
	}
	
	static int bfs(int s, boolean[] visited2, LinkedList<Integer>[] arrList2) {
		LinkedList<Integer> queue = new LinkedList<>();
		int numOfVertices = 0;
		queue.add(s);
		visited2[s] = true;
		
		while(queue.size() != 0) {
			s = queue.poll();
			numOfVertices++;
			for(int j = 0; j < arrList2[s].size(); j++) {
				if(!visited2[arrList2[s].get(j)]) {
					queue.add(arrList2[s].get(j));
					visited2[arrList2[s].get(j)] = true;
				}
			}
		}
		return numOfVertices;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int q = in.nextInt();
		
		while(q-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			long cLib = in.nextLong();
			long cRoad = in.nextLong();
			
			LinkedList<Integer>[] arrList = new LinkedList[n];
			boolean[] visited = new boolean[n];
			
			for(int i = 0; i < n; i++) {
				arrList[i] = new LinkedList<>();
			}
			
			for(int i = 0; i < m; i++) {
				int u = in.nextInt();
				int v = in.nextInt();
				u--;
				v--;
				arrList[u].add(v);
				arrList[v].add(u);
			}
			
			long cost = 0;
			if(cLib <= cRoad) {
				cost += n*cLib;
			} else {
				cost = connectedComponents(visited, arrList, cLib, cRoad);
			}
			System.out.println("cost - " + cost);
		}
	}
}