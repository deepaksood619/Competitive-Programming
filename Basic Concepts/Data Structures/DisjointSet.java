// http://www.geeksforgeeks.org/disjoint-set-data-structures-java-implementation/

/*
    Path Compression - It speeds up the data structure by compressing the height of the trees. It can be achieved by inserting a small caching mechanism into the Find operation.

    Union by Rank - minimize the height of the resulting tree

    Time Complexity - 
        MakeSet - O(1)
        Find Operation - O(log(N))
        Union Operation - O(log(N))

    Space Complexity - 2*O(N) - O(N)
*/

class DisjointSet {

    int[] parent;
    int[] rank;
    int n;

    DisjointSet(int n) {
        this.n = n;
        parent = new int[n];
        rank = new int[n];
        makeSet();
    }

    void makeSet() {
        // every element is the parent of itself
        for(int i = 0; i < this.n; i++) {
            parent[i] = i;
        }
    }

    int find(int n) {

        // using Path Compression

        if(parent[n] != n) {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }

    void union(int x, int y) {

        // using Union by Rank

        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot == yRoot) {
            return;
        } else if(rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if(rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++; 
        }
    }

    public static void main(String[] args) {
        int n = 5;
        DisjointSet dus =
                       new DisjointSet(n);
 
        // 0 is a friend of 2
        dus.union(0, 2);
 
        // 4 is a friend of 2
        dus.union(4, 2);
 
        // 3 is a friend of 1
        dus.union(3, 1);
 
        // Check if 4 is a friend of 0
        if (dus.find(4) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        // Check if 1 is a friend of 0
        if (dus.find(1) == dus.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}