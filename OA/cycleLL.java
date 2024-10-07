package localrepo.OA;

//Write a function that returns 
//the number of pairs of integers in an array whose sum is equal to a given target value.
public class cycleLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static Node detect(Node head) {
        Node hare = head;
        Node turtle = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (turtle == hare) {
                return turtle;
            }
        }
        return null;
    }

}
