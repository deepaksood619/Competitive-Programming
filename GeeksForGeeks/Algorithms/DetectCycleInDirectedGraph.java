// http://www.geeksforgeeks.org/?p=18516
// http://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

/*
 Using DFS
 Depth First Traversal can be used to detect cycle in a Graph. 
 DFS for a connected graph produces a tree. 
 There is a cycle in a graph only if there is a back edge present in the graph.
 A back edge is an edge that is from a node to itself (selfloop) or one of its ancestor in the tree produced by DFS.

 To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal. 
 If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. 
 The edge that connects current vertex to the vertex in the recursion stack is back edge. 

 Time Complexity - O(V+E)
 Space Complexity - O(V+E)
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while(T-- > 0) {
            int N = in.nextInt();
            int M = in.nextInt();

            Graph graph = new Graph(N);

            for(int i = 0; i < M; i++) {
                int u = in.nextInt();
                int v = in.nextInt();

                graph.addEdge(u, v);

            }

            System.out.println(graph.detectCycle());
        }
    }
}

class Graph {
    int N;
    ArrayList<LinkedList<Integer>> adjList;
    boolean[] visited;
    boolean[] explored;

    Graph(int N) {
        this.N = N;
        adjList = new ArrayList<>(N);
        visited = new boolean[N];
        explored = new boolean[N];

        for(int i = 0; i < N; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    boolean detectCycle() {
        for(int i = 0; i < N; i++) {
            if(dfs(i)) {
                return true;
            }
        }
        return false;
    }

    boolean dfs(int src) {
        if(!visited[src]) {
            visited[src] = true;
            explored[src] = true;
            
            Iterator<Integer> iterator = adjList.get(src).iterator();

            int vertex = 0;

            while(iterator.hasNext()) {
                vertex = iterator.next();
                if(!visited[vertex] || !explored[src]) {
                    if(dfs(vertex)) {
                        return true;
                    }
                } else {
                    return true;
                }
            }
            explored[src] = false;
        }
        return false;
    }
}