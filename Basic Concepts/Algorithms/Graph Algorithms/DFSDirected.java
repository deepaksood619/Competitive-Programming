// http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/

/*
	Time Complexity: O(V+E) where V is number of vertices in the graph and E is number of edges in the graph.
*/

import java.util.LinkedList;

class DFSDirected {
	
	int numOfVertices;
	LinkedList<Integer>[] adjList;
	
	DFSDirected(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		
		adjList = new LinkedList[numOfVertices];
		
		for(int i = 0; i < numOfVertices; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
	}
	
	void addEdge(int u, int v) {
		adjList[u].add(v);
	}
	
	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 0; i < adjList[v].size(); i++) {
			int n = adjList[v].get(i);
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	void dfs(int s) {
		boolean[] visited = new boolean[numOfVertices];
		
		DFSUtil(s, visited);
	}
	
	void dfsAll() {
		boolean[] visited = new boolean[numOfVertices];
		
		for(int i = 0; i < numOfVertices; i++) {
			if(!visited[i]) {
				DFSUtil(i, visited);
			}
		}
	}
	
	void print() {
		for(int i = 0; i < numOfVertices; i++) {
			System.out.print(i + " - ");
			for(int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		DFSDirected dfsObject = new DFSDirected(4);
		
		dfsObject.addEdge(0, 1);
		dfsObject.addEdge(0, 2);
		dfsObject.addEdge(1, 2);
		dfsObject.addEdge(2, 0);
		dfsObject.addEdge(2, 3);
		dfsObject.addEdge(3, 3);
		
		dfsObject.print();
		
		dfsObject.dfs(2);
		System.out.println();
		dfsObject.dfsAll();
	}
}