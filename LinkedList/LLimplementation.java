package localrepo.LinkedList;

import java.util.*;

/**
 * LLimplementation
 */
public class LLimplementation {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // 1.Adding at tthe first node
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 2.Add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
            currNode.next = newNode;
        }
    }

    void nthRemove(int n) {
        // 1.First find the size of the list
        if (head == null) {
            return;
        }
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        if (size == n) {
            head = head.next;
            System.out.println(head.data);
        }
        if (n > size) {
            return;
        }
        int indToSearch = size - n;
        Node prev = head;
        int i = 1;
        while (i < indToSearch) {
            prev = prev.next;
            i++;
        }
        // Remove the nth node from the end
        if (prev.next != null) {
            prev.next = prev.next.next;
        }

    }

    // 3.Printing the linked list
    public void printLL() {
        if (head == null)
            System.out.println("List is Empty!!");
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "-> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LLimplementation ob = new LLimplementation();

        // Adding elements to the linked list
        ob.addFirst(2);
        ob.addFirst(5);
        ob.addFirst(4);
        ob.addFirst(3);

        // Printing the linked list
        ob.printLL();

        // Removing the 2nd node from the end
        ob.nthRemove(2);

        // Printing the linked list after removal
        ob.printLL();
    }

}