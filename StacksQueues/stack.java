package localrepo.StacksQueues;

//Implementation of stack using linked list
public class stack {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (isEmpty())
            return -1;
        int top = head.data;
        head = head.next;
        return top;
    }

    public int peek() {
        if (isEmpty())
            return -1;
        return head.data;
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(0);
        s.push(1);
        s.push(2);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            // Stack follows last-in-first-out
            // So the O/P is 2 1 0
            s.pop();
        }
    }
}
