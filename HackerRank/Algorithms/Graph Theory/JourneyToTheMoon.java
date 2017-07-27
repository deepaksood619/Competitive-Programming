// https://www.hackerrank.com/challenges/journey-to-the-moon

/*

	Initial Solution - Using DFS find the connected components and number of vertices in each connected components
	
	Equation - No of permutations in connected components
				(a*b) + (a+b)*c + (a+b+c)*d + ...
				
	Time Complexity - O(|V + E|) as in the connected components for an undirected graph
	Space Complexity - O(|V|) as at worst case hold all the vertices

Test Case 1 -
5 3
0 1
2 3
0 4

Test Case 2 -
10 7
0 2
1 8
1 4
2 8
2 6
3 5
6 9

Test Case 3 - 
4 1
0 2

Large Test Case -
100000 2
1 2
3 4
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class JourneyToTheMoon {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int P = in.nextInt();
		
		Graph graph = new Graph(N);
		
		for(int i = 0; i < P; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			
			graph.addEdge(a, b);
		}
		
		//graph.print();
		
		System.out.println(graph.connectedComponents());
	}
}

class Graph {
	int numOfVertices;
	
	ArrayList<LinkedList<Integer>> adjList;
	
	Graph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		adjList = new ArrayList<>(numOfVertices);
		
		for(int i = 0; i < numOfVertices; i++) {
			adjList.add(new LinkedList<>());
		}
	}
	
	void addEdge(int a, int b) {
		adjList.get(a).add(b);
		adjList.get(b).add(a);
	}

	void print() {
		for(int i = 0; i < numOfVertices; i++) {
			System.out.print(i + " - ");
			for(int j = 0; j < adjList.get(i).size(); j++) {
				System.out.print(adjList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	long connectedComponents() {
		boolean[] visited = new boolean[numOfVertices];
		
		ArrayList<Integer> numOfVerticesComponents = new ArrayList<>();
		long permutations = 0;
		
		for(int i = 0; i < numOfVertices; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				int num = 1;
				num = dfs(i, visited, num);
				numOfVerticesComponents.add(num);
				
				if(numOfVerticesComponents.size() > 1) {
					int sum = 0;
					int j = 0;
					for(j = 0; j < numOfVerticesComponents.size()-1; j++) {
						sum += numOfVerticesComponents.get(j);
					}
					permutations += sum * numOfVerticesComponents.get(j);
				}
			}
		}
		return permutations;
	}
	
	int dfs(int s, boolean[] visited, int num) {
		for(int i = 0; i < adjList.get(s).size(); i++) {
			int n = adjList.get(s).get(i);
			if(!visited[n]) {
				num++;
				visited[n] = true;
				num = dfs(n, visited, num);
			}
		}
		return num;
	}
}