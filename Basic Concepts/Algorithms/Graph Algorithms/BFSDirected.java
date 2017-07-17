// http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/

import java.util.LinkedList;
import java.util.Iterator;

class BFSDirected {
	
	int numOfVertices;
	LinkedList<Integer>[] adjacencyList;
	
	BFSDirected(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		adjacencyList = new LinkedList[numOfVertices];
		
		while(numOfVertices-- > 0) {
			adjacencyList[numOfVertices] = new LinkedList<>();
		}
	}
	
	void addEdge(int v, int w) {
		adjacencyList[v].add(w);
	}
	
	void bfs(int s) {
		
		boolean[] visited = new boolean[numOfVertices];
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		queue.add(s);
		visited[s] = true;
		
		while(queue.size() != 0) {
			
			s = queue.poll();
			
			System.out.print(s + " ");
			
			// now get the neighbors and add it to queue
			// using iterator
			Iterator<Integer> i = adjacencyList[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					queue.add(n);
					visited[n] = true;
				}
			}
			
			
			// using loop
			/*for( int i = 0; i < adjacencyList[s].size(); i++) {
				if(!visited[adjacencyList[s].get(i)]) {
					queue.add(adjacencyList[s].get(i));
					visited[adjacencyList[s].get(i)] = true;
				}
			}*/
		}
	}
	
	void print() {
		for(int i = 0; i < adjacencyList.length; i++) {
			System.out.print(i + " - ");
			for(int j = 0; j < adjacencyList[i].size(); j++) {
				System.out.print(adjacencyList[i].get(j) + " ");
			}
			System.out.println();
		}
	}	
	
	public static void main(String[] args) {
		
		BFSDirected bfsDirected = new BFSDirected(4);
		bfsDirected.addEdge(0, 1);
		bfsDirected.addEdge(0, 2);
		bfsDirected.addEdge(1, 2);
		bfsDirected.addEdge(2, 0);
		bfsDirected.addEdge(2, 3);
		bfsDirected.addEdge(3, 3);
		
		bfsDirected.print();
		
		bfsDirected.bfs(2);
		
	}
	
}