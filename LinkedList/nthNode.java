package localrepo.LinkedList;

public class nthNode {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void nthRemove(Node head, int n) {
        // 1.First find the size of the list
        if (head == null) {
            return;
        }
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (size == n) {
            head = head.next;
            System.out.println(head.data);
        }
        if (n > size) {
            return;
        }
        int indToSearch = size - n;
        Node prev = head;
        int i = 1;
        while (i < indToSearch) {
            prev = prev.next;
            i++;
        }
        // Remove the nth node from the end
        if (prev.next != null) {
            prev.next = prev.next.next;
        }

    }
}
