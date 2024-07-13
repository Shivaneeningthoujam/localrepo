package localrepo.LinkedList;

public class multiply2LL {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static long multi(Node first, Node sec) {
        long N = 1000000007;
        long num1 = 0, num2 = 0;
        while (first != null || sec != null) {
            if (first != null) {
                num1 = ((num1) * 10) % N + first.val;
                first = first.next;
            }
            if (sec != null) {
                num2 = ((num2) * 10) % N + sec.val;
            }
        }
        return ((num1 % N) * (num2 % N)) % N;
    }

}
