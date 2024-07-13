package localrepo.LinkedList;

//This one is important.We have to reverse a Doubly LinkedList
public class reverseDLL {
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node revDLL(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node Next = curr.next;
            curr.next = curr.prev;
            curr.prev = Next;
            prev = curr;
            curr = Next;
        }
        return prev;
    }

}
