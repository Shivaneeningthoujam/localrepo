package localrepo.OA;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

//practicing stack implementation with array and LL
class StackL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;

    static boolean isEmpty() {
        return head == null;
    }

    static void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    static int pop() {
        if (head == null)
            return -1;
        int top = head.data;
        head = head.next;
        return top;
    }

    public static int peek() {
        if (head == null)
            return -1;
        return head.data;// here the head of the linked list is acting as the top of the stack
    }

    // finding kth smallest element with max heap
    static int findk(int arr[], int k) {
        // initialise a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Add first k elements
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        // process the remaining elements
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();// kick the top out
                pq.add(arr[i]);// and add the current element
            }
        }
        return pq.peek();
    }

    // return the 2nd largest element
    static int findLarg(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        // process the rest
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    // find the missing element in an array .Elements are from 1-N
    static int miss(int arr[], int n) {
        int sum = n * (n + 1) / 2;
        for (int i : arr) {
            sum -= i;
        }
        return sum;
    }

    // merge two sorted array
    static int[] merged(int a1[], int a2[], int m, int n) {
        int res[] = new int[m + n];
        // 1st loop
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            // running up for equal common lengths in the 2 array
            if (a1[i] < a2[j]) {
                res[k++] = a1[i++];
            } else {
                res[k++] = a2[j++];
            }
        }
        // handling remaining elements of a1[]
        while (i < m) {
            res[k++] = a1[i++];
        }
        // handling a2[]
        while (j < n) {
            res[k++] = a2[j++];
        }
        return res;
    }

    // intersection of 2 linked list
    static Node llInter(Node l1, Node l2) {
        HashSet<Node> visited = new HashSet<>();
        // Traverse the first list and store all the elements in the set
        Node curr1 = head;
        while (curr1 != null) {
            visited.add(curr1);
            curr1 = curr1.next;
        }
        // traverse the 2nd ll and check if any element is found common
        Node curr2 = head;
        while (curr2 != null) {
            if (visited.contains(curr2)) {
                // found intersection
                return curr2;
            }
            curr2 = curr2.next;
        }
        return null;
    }

    // check if a number is prime
    static boolean isPrime(int n) {
        // a prime number can't be less than or equal to 1
        if (n <= 1)
            return false;
        // next iteration starts from i=2
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        // push(2);
        // push(1);
        // push(4);
        // push(5);
        // while (!isEmpty()) {
        // System.out.print(peek() + " ");
        // pop();
        // }
        // int arr[] = { 3, 2, 6, 4 };
        // int k = 2;
        // System.out.println(findLarg(arr, k));
        // System.out.println(findk(arr, k));
        // int arr[] = { 1, 2, 3, 4 };
        // int n = 5;
        // System.out.println(miss(arr, n));
        int a1[] = { 2, 3, 5, 8, 11 };
        int a2[] = { 1, 4, 9, 12 };
        int m = 5, n = 4;
        int res[] = merged(a1, a2, m, n);
        for (int i : res) {
            System.out.print(i + " ");
        }

    }

}
