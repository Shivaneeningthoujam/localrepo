package localrepo.OA;

class Node {
    Node head;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class loopLL {
    static boolean detectLoop(Node head) {
        if (head == null || head.next == null)
            return false;
        // using Floyd cycle detection
        Node turtle = head, hare = head;
        while (hare.next != null || hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (turtle == hare)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
