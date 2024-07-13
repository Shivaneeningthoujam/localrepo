package localrepo.LinkedList;
//We are given two LinkedLists ,We have to find their point of intersection

public class intersectionLL {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node getIntersect(Node head1, Node head2) {
        // use 2 nested loops
        // Inner looop->check if any of the nodes of 2nd LL==1st LL
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                // if both are same
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

}
