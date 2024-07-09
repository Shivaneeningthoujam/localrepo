package localrepo.LinkedList;

//Implementation of Node
public class midLL {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static int mid(Node head) {
        int count = 0;
        for (Node curr = head; curr != null; curr = curr.next) {
            count = count + 1;
        }
        int mid = count / 2;
        Node curr = head;
        for (int i = 0; i < mid; i++) {
            curr = curr.next;

        }
        return curr.data;
    }
}
