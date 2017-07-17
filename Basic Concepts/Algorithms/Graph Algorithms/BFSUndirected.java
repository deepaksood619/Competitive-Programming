// http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/

import java.util.LinkedList;
import java.util.Iterator;

class BFSUndirected {
	
	int numOfVertices;
	
	LinkedList<Integer> adjacencyList[];
	
	BFSUndirected(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		adjacencyList = new LinkedList[numOfVertices];
		while(numOfVertices-- > 0) {
			adjacencyList[numOfVertices] = new LinkedList();
		}
	}
	
	void addEdge(int v1, int v2) {
		adjacencyList[v1].add(v2);
		adjacencyList[v2].add(v1);
	}
	
	void printGraph() {
		for(int i = 0; i < adjacencyList.length; i++) {
			System.out.print(i + " - ");
			for(int j = 0; j < adjacencyList[i].size(); j++) {
				System.out.print(adjacencyList[i].get(j) + " ");
			}
			System.out.println();
		}
	}
	
	void bfs(int s) {
		
		boolean[] visited = new boolean[numOfVertices];
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			
			// now find the neighbors and add it to queue
			
			//using Iterator
			Iterator<Integer> i = adjacencyList[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
			
			// using adjacencyList directly
			/* for(int i = 0; i < adjacencyList[s].size(); i++) {
				if(!visited[adjacencyList[s].get(i)]) {
					queue.add(adjacencyList[s].get(i));
					visited[adjacencyList[s].get(i)] = true;
				}
			} */
		}
	}
	
	public static void main(String[] args) {
		System.out.println("BFS");
		
		BFSUndirected bfsUndirected = new BFSUndirected(4);
		
		bfsUndirected.addEdge(0, 1);
		bfsUndirected.addEdge(0, 2);
		bfsUndirected.addEdge(1, 2);
		bfsUndirected.addEdge(2, 0);
		bfsUndirected.addEdge(2, 3);
		bfsUndirected.addEdge(3, 3);
		
		bfsUndirected.printGraph();
		
		bfsUndirected.bfs(2);
		
	}
}