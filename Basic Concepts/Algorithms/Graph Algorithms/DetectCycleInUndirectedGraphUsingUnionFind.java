import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// http://www.geeksforgeeks.org/?p=26350

/*
    Using union find subset algorithm
    using path compression
    using union by rank

    Time Complexity - O(V log(V)) bcoz if there is a cycle it will return immediately after the Vth edge,
                        bcoz there can only be V-1 edges in a graph with no cycle
        Union - O(log(n))
        Find - O(log(n))

    Space Complexity - O(V+E)
*/

class DetectCycleInUndirectedGraphUsingUnionFind {

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(0, 3);

        String sol = graph.findCycle() ? "Yes" : "No";
        System.out.println(sol);
    }
}

class Graph {
    int n;
    ArrayList<LinkedList<Integer>> adjList;
    int[] parent;
    int[] rank;

    Graph(int n) {
        this.n = n;
        adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new LinkedList<>());
        }

        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    void addEdge(int x, int y) {
        adjList.get(x).add(y);
    }

    boolean findCycle() {
        for(int i = 0; i < n; i++) {
            Iterator<Integer> iterator = adjList.get(i).iterator();

            while(iterator.hasNext()) {
                int x = iterator.next();
                int parentI = find(i);
                int parentX = find(x);
                if(parentI != parentX) {
                    union(i, x);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    // path compression
    int find(int i) {
        if(parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent[i]);
            return parent[i];
        }
    }

    // union by rank
    void union(int i, int j) {
        int irep = find(i);
        int jrep = find(j);

        if(irep == jrep) {
            return;
        }

        int irank = rank[irep];
        int jrank = rank[jrep];

        if(irank < jrank) {
            this.parent[irep] = jrep;
        } else if(jrank < irank) {
            this.parent[jrep] = irep;
        } else {
            parent[irep] = jrep;
            rank[jrep]++;
        }
    }
}