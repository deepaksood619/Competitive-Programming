// http://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/

/*
	SpaceComplexity - O(|V|), since at worst case you need to hold all vertices in the queue.
	
	TimeComplexity - O(|V|) where |V| is the number of nodes, you need to traverse all nodes. 
*/

import java.util.LinkedList;

class ConnectedComponentsUndirectedGraph {
	
	LinkedList<Integer>[] arrList;
	boolean[] visited;
	int numOfVertices;
	
	ConnectedComponentsUndirectedGraph(int numOfVertices) {
		this.numOfVertices = numOfVertices;
		arrList = new LinkedList[numOfVertices];
		visited = new boolean[numOfVertices];
		
		for(int i = 0; i < numOfVertices; i++) {
			arrList[i] = new LinkedList<>();
		}
	}
	
	void addEdge(int v, int w) {
		arrList[v].add(w);
		arrList[w].add(v);
	}
	
	void print() {
		for(int i = 0; i < arrList.length; i++) {
			System.out.print(i + " - ");
			for(int j = 0; j < arrList[i].size(); j++) {
				System.out.print(arrList[i].get(j) + " ");
			}
			System.out.println();
		}
	}
	
	void connectedComponent() {
		for(int i = 0; i < visited.length; i++) {
			if(!visited[i]) {
				bfs(i);
				System.out.println();
			}
		}
	}
	
	void bfs(int s) {
		LinkedList<Integer> queue = new LinkedList<>();
		
		visited[s] = true;
		queue.add(s);
		
		while(queue.size() != 0) {
			s = queue.poll();
			
			System.out.print(s + " ");
			
			for(int i = 0; i < arrList[s].size(); i++) {
				if(!visited[arrList[s].get(i)]) {
					queue.add(arrList[s].get(i));
					visited[arrList[s].get(i)] = true;
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		System.out.println("Connected Components in an Undirected Graph");
		
		ConnectedComponentsUndirectedGraph object = new ConnectedComponentsUndirectedGraph(5);
		object.addEdge(0, 1);
		object.addEdge(2, 0);
		object.addEdge(3, 4);
		
		object.print();
		
		object.connectedComponent();
	}
}