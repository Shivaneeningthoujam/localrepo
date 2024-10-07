package localrepo.OA;

import java.util.*;

public class stackLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            // constructor
            this.data = data;
            this.next = null;
        }

        static Node head;

        static void push(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            }
            newNode.next = head;
            head = newNode;
        }

        static int pop() {
            int top = head.data;
            head = head.next;
            return top;
        }

        static boolean isEmpty() {
            return head == null;
        }

        static int peek() {
            if (isEmpty())
                return -1;
            return head.data;
        }
    }

    // deleting mid of a stack
    static void delMid(Stack<Integer> s, int size) {
        int mid = size / 2;
        Stack<Integer> temp = new Stack<>();
        for (int i = 1; i < mid + 1; i++) {
            temp.push(s.pop());
        }
        s.pop();// deleted mid
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    // add a node at the bottom of the stack
    static void addBot(int data, Stack<Integer> s) {
        if (s.isEmpty())
            s.push(data);// 2.adds the desired data
        int top = s.pop();
        addBot(data, s);// 1.makes the stack empty
        s.push(top);// pushes back the prev elements
    }

    // Evaluation of postfix using Stack
    // given a string of postfix expression ,evaluate it
    public static int postEv(String s) {
        Stack<Integer> m = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                m.push(c - '0');
            } else {
                int val1 = m.pop();
                int val2 = m.pop();
                switch (c) {
                    case '+':
                        m.push(val2 + val1);
                        break;

                    case '*':
                        m.push(val2 * val1);
                        break;
                    case '/':
                        m.push(val2 / val1);
                        break;
                    case '-':
                        m.push(val2 - val1);
                        break;
                }
            }
        }
        return m.pop();
    }

    // Sort a stack using recursion
    static void sortSt(Stack<Integer> s) {
        if (s.isEmpty())
            return;
        int top = s.pop();
        sortSt(s);
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty() && top > s.peek()) {
            temp.push(s.pop());
        }
        s.push(top);
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }
    // adding a node at the bottom of a stack using recursion
}
