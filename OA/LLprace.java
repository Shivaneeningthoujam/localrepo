package localrepo.OA;

import java.util.HashSet;
import java.util.Stack;

public class LLprace {
    // reverse a LL using recursion
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static Node rev(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = rev(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Mid of a LL floyd's cycle
    static Node midLL(Node head) {
        Node turtle = head;
        Node hare = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    // Merge two sorted LL
    static Node merge(Node l1, Node l2) {
        if (l2 == null)
            return l1;
        if (l1 == null)
            return l2;
        if (l1.data > l2.data) {
            l2.next = merge(l1, l2.next);
            return l2;
        } else {
            l1.next = merge(l1.next, l2);
            return l1;
        }
    }

    static Node rem(Node head, int k) {
        // Find the size
        int size = 0;
        if (head == null)
            return null;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (size == k)
            return head.next;
        int idxToSearch = size - k;
        int i = 1;
        Node prev = head;
        while (i < idxToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return prev;
    }

    // LL is a Palindrome?
    // 1st find the mid ,then reverse the 2nd half after the mid and compare the 1st
    // and 2nd half
    static boolean palin(Node head) {
        // base case
        if (head == null || head.next == null)
            return true;
        Node mid = midLL(head);
        Node secondHalf = rev(mid.next);
        Node firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf != null) {
                if (firstHalf.data != secondHalf.data)
                    return false;
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }

    // remove duplicate from a sorted linked list
    static Node remDup(Node head) {
        if (head == null || head.next == null)
            return head;
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }

    // LL intersection
    static Node getIntersection(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                // If bothe Nodes are same we found the intersection
                if (temp == head2) {
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    // Rotate a LL by k to the right
    static Node rot(Node head, int k) {
        // base case
        if (head.next == null || head == null)
            return head;
        // create a dummy before head
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;
        int l;// initialise length to find the length of the LL
        for (l = 0; fast.next != null; l++) {
            fast = fast.next;
        }
        for (int j = l - k % l; j > 0; j--) {
            // get the l-k%l th node
            slow = slow.next;
        }
        // rotation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    // removing duplicate from an unsorted LL
    static Node remDupl(Node head) {
        if (head == null || head.next == null)
            return head;
        // create a hashset
        HashSet<Integer> seen = new HashSet<>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (seen.contains(curr)) {
                prev.next = curr.next;
            }
            seen.add(curr.data);
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    // add first
    static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    // add Last
    static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // printing LL
    static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + "-->");
            curr = curr.next;
        }
    }

    // intersection of two LL
    static int interLL(Node l1, Node l2) {
        HashSet<Integer> seen = new HashSet<>();
        Node curr = l1;
        while (curr != null) {
            seen.add(curr.data);
            curr = curr.next;
        }
        curr = l2;
        while (curr != null) {
            if (seen.contains(curr)) {
                return curr.data;
            }
            curr = curr.next;
        }
        return -1;
    }

    // check if the parenthesis are balanced
    static boolean isBalanced(String exp) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
                continue;
            }
            if (st.isEmpty())
                return false;
            char check;
            switch (c) {
                case ']':
                    check = st.pop();
                    if (check == '{' || check == '(')
                        return false;
                    break;
                case ')':
                    check = st.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = st.pop();
                    if (check == '[' || check == '(')
                        return false;
                    break;

            }
        }
        return st.isEmpty();
    }
}
