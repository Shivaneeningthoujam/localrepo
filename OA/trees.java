package localrepo.OA;

class Node {
    int data;
    Node left;
    Node right;

    Node() {

    }

    Node(int data) {
        this.data = data;
    }

    Node(int data, Node left, Node right) {
        this.data = data;
        this.right = right;
        this.left = left;
    }
}

public class trees {
    // given two trees , check if they are identical
    public static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    // given two trees , check if 2nd tree is a subset of 1st tree
    public static boolean isSubset(Node root, Node subroot) {
        if (subroot == null)
            return true;
        if (root == null)
            return false;
        if (root.data == subroot.data) {
            if (isIdentical(root, subroot)) {
                return true;
            }

        }
        return isSubset(root.left, subroot) || isSubset(root.right, subroot);
    }
}
