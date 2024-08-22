package localrepo.OA;

import java.util.*;

public class tree {
    static class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class buildTree {
        static int idx = -1;

        static Node buildTree(int node[]) {
            idx++;
            if (node[idx] == -1)
                return null;
            Node newNode = new Node(node[idx]);
            newNode.left = buildTree(node);
            newNode.right = buildTree(node);
            return newNode;
        }
    }

    static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);// first element
        q.add(null);// thn null to indicate to print next line
        while (!q.isEmpty()) {
            Node curr = q.remove();// remove the first element from the queue
            if (curr == null) {
                System.out.println();// if u find null=>next line
                if (q.isEmpty())
                    break;// if the q is empty =>break
                else
                    q.add(null);
            } else {
                System.out.println(curr.data + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null)
                    q.add(curr.right);
            }

        }
    }
}
