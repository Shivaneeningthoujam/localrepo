package localrepo.OA;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stack {

    // we are to implement stack using Linked List
    // 1.isEmpty
    public static Node head;

    public static boolean isEmpty() {
        return head == null;
    }

    // 2.push
    public static void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    // 3.pop
    public static int pop() {
        if (head == null)
            return -1;
        int top = head.data;
        head = head.next;
        return top;
    }

    // 4.peek
    public static int peek() {
        if (isEmpty())
            return -1;
        return head.data;
    }
}
