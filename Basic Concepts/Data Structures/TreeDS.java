// http://www.geeksforgeeks.org/binary-tree-set-1-introduction/

class Node {
    int key;
    Node left, right;

    Node(int key) {
        this.key = key;
        left = right = null;
    }
}

class TreeDS {

    Node root;

    TreeDS() {
        root = null;
    }

    public static void main(String[] args) {
        TreeDS tree = new TreeDS();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
    }
}