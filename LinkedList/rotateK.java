package localrepo.LinkedList;

//Given a Linked list ,we have to rotate the first k elements of the LL to the right
public class rotateK {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node rotateRight(Node head, int k) {
        // APPROACH:
        // base case
        // get the length
        // Move to (l-k%l)th node
        // Do the rotation
        if (head == null || head.next == null)
            return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;
        int l;// to store the length
        for (l = 0; fast.next != null; l++) {
            fast = fast.next;
        }
        for (int j = l - k % l; j > 0; j--)
            slow = slow.next;
        // rotation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
