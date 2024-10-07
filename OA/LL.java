package localrepo.OA;

import java.util.HashSet;

public class LL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    // adding nodes in the first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print LL
    public void printLL() {
        if (head == null) {
            System.out.println("LL is empty");
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // reversing a LL
    Node rev(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = rev(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static Node mid(Node head) {
        Node hare = head;
        Node turtle = head;
        while (hare.next != null || hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    // checking if a LL is a palindrome
    public boolean isPalin(Node head) {
        if (head == null || head.next == null)
            return true;
        Node mid = mid(head);
        Node secondHalf = rev(mid.next);
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf != secondHalf)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }

    // remove duplicate from a sorted LL
    public Node remDup(Node head) {
        if (head == null || head.next == null)
            return head;
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    // find the nth node from the last and remove it
    public Node removeNth(Node head, int n) {
        int size = 0;
        if (head.next == null)
            return null;
        // find the size
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (n == size)
            return head;
        int idxToSearch = size - n;
        Node prev = head;
        int i = 1;
        while (i < idxToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    // code to remove duplicate from an unsorted LL-using hashMap
    public static void removeDup(Node head) {
        if (head == null || head.next == null)
            return;
        HashSet<Integer> seen = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (seen.contains(curr.data)) {
                prev.next = curr.next;
            }
            seen.add(curr.data);
            prev = curr;
            curr = curr.next;
        }
    }

    // Sorting 0s,1s,2s in LL
    static Node sort(Node head) {
        Node curr = head;
        // create count array to store the frequency
        int count[] = { 0, 0, 0 };// initialised the frequency
        while (curr != null) {
            count[curr.data]++;
            curr = curr.next;
        } // we got the frequencies
        curr = head;
        int i = 0;// start arranging the values into LL
        while (curr != null) {
            if (count[i] == 0) {
                // means we finished arranging the current node
                i++;// pass it to next node
            } else {
                curr.data = i;
                --count[i];// decrease the frequency by 1 after arranging
                curr = curr.next;

            }
        }
        return head;
    }

    // merging two sorted linked list
    static Node merger(Node l1, Node l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.data > l2.data) {
            l2.next = merger(l1, l2.next);
            return l2;
        } else {
            l1.next = merger(l1.next, l2);
            return l1;
        }
    }

    // merging 2 sorted LL
    static Node mergere(Node h1, Node h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h2.data < h1.data) {
            h2.next = merger(h1, h2.next);
            return h2;
        } else {
            h1.next = merger(h1.next, h2);
            return h1;
        }
    }

    public static void main(String[] args) {
        LL ob = new LL();
        ob.addFirst(0);
        ob.addFirst(1);
        ob.addFirst(2);
        ob.addFirst(3);
        ob.addFirst(4);
        ob.printLL();

    }
}