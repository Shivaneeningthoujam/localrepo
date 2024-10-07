package localrepo.OA;

import java.util.*;

public class binarytree {
    // Implementation
    // A binary tree has a root node ,left and right child
    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int nodes[]) {
        idx++;
        if (nodes[idx] == -1)
            return null;
        Node newNode = new Node(nodes[idx]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void preorder(Node root) {
        if (root == null)
            return;
        // NLR
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void levelOrder(Node root) {
        // The idea is printing next line when u come across null in the queue
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr == null) {
                System.out.println();
                if (q.isEmpty())
                    break;
                else
                    q.add(null);// null is added as soon as the other null is used for next line
            } else {
                System.out.println(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

    }

    public static int CountNodes(Node root) {
        if (root == null)
            return 0;
        int leftNodes = CountNodes(root.left);
        int righttNodes = CountNodes(root.right);
        return leftNodes + righttNodes + 1;
    }

    public static int sumOfNodes(Node root) {
        if (root == null)
            return 0;
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.data;
    }

    public static int treeHeight(Node root) {
        if (root == null)
            return 0;
        int left = treeHeight(root.left);
        int rigth = treeHeight(root.right);
        return Math.max(left, rigth) + 1;
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = treeHeight(root.left) + treeHeight(root.right) + 1;
        return Math.max(dia1, Math.max(dia2, dia3));
    }
}
