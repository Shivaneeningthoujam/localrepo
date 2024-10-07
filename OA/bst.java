package localrepo.OA;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;

    }
}

public class bst {
    static Node insert(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (root.data > x) {
            root.left = insert(root.left, x);
        } else {
            root.right = insert(root.right, x);
        }
        return root;
    }
}
