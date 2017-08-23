import java.util.*;

// http://www.geeksforgeeks.org/?p=26604

class KruskalMST {

    public static void main(String[] args) {
        int V = 9, E =14;
        Graph graph = new Graph(V, E);

        graph.add(0, 0, 1, 4);
        graph.add(1, 0, 7, 8);
        graph.add(2, 1, 7, 11);
        graph.add(3, 1, 2, 8);
        graph.add(4, 7, 6, 1);
        graph.add(5, 7, 8, 7);
        graph.add(6, 2, 8, 2);
        graph.add(7, 6, 8, 6);
        graph.add(8, 2, 3, 7);
        graph.add(9, 2, 5, 4);
        graph.add(10, 6, 5, 2);
        graph.add(11, 5, 4, 10);
        graph.add(12, 5, 3, 14);
        graph.add(13, 3, 4, 9);
 
        graph.FuncKruskalMST();
        
    }

}

class Graph {

    Edge[] edge;
    int V, E;

    Graph(int V, int E) {
        this.V = V;
        this.E = E;
        edge = new Edge[E];
        for(int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    void add(int index, int src, int dest, int weight) {
        edge[index].src = src;
        edge[index].dest = dest;
        edge[index].weight = weight;
    }

    int find(subset[] subsets, int i) {
        if(subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void Union(subset[] subsets, int x, int y) {
        int xRoot = x;
        int yRoot = y;

        if(subsets[xRoot].rank < subsets[yRoot].rank) {
            subsets[xRoot].parent = yRoot;
        } else if(subsets[xRoot].rank > subsets[yRoot].rank) {
            subsets[yRoot].parent = xRoot;
        } else {
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    void FuncKruskalMST() {
        Edge[] result = new Edge[V-1];
        for(int i = 0; i < V-1; i++) {
            result[i] = new Edge();
        }

        Arrays.sort(edge, new Comparator<Edge>(){
            @Override
            public int compare(Edge a, Edge b) {
                return Integer.compare(a.weight, b.weight);
            }
        });

        System.out.println(Arrays.toString(edge));

        subset[] subsets = new subset[V];

        for(int i = 0; i < V; i++) {
            subsets[i] = new subset();
        }

        for(int i = 0; i < V; i++) {
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        int i = 0;
        int e = 0;

        while(e < V-1) {
            Edge newEdge = edge[i++];

            int x = find(subsets, newEdge.src);
            int y = find(subsets, newEdge.dest);
    
            if(x != y) {
                result[e++] = newEdge;
                Union(subsets, x, y);
            }
        }

        System.out.println(Arrays.toString(result));
    }
}

class Edge {
    int src;
    int dest;
    int weight;

    @Override
    public String toString() {
        return "src- " + src + " dest- " + dest + " weight- " + weight + "\n";
    }
}

class subset {
    int parent;
    int rank;
}