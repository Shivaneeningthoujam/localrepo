package localrepo.LinkedList;

//We are to detect any loop in a LL and remove it
public class detectRemoveLoop {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static void detectRemove(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                break;

        }
        // if loop is detected
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;

                }
                fast.next = null;// removes the loop as it is where the loop starts
            }
            // if fast and slow meet at tthe first position
            else {
                while (fast.next != slow) {
                    fast = fast.next;
                }
                fast.next = null;
            }
        }
    }
}
