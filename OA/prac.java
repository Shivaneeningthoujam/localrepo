// package localrepo.OA;

import java.util.*;

// import localrepo.OA.stack;

public class prac {
    // static int fibo(int n) {
    // if (n == 1 || n == 0) {
    // return 1;

    // }
    // return fibo(n - 1) + fibo(n - 2);
    // }

    static int[] twoSum(int arr[], int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] + arr[j] == k)
                    return new int[] { arr[i], arr[j] };
            }
        }
        return new int[] {};
    }

    // Find and remove Nth node from end
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head;

    static Node removeN(Node head, int n) {
        if (head.next == null || head == null)
            return null;
        // 1.Find the size of the linkedlist
        int size = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        if (size == n)
            return head;
        int idxToSearch = size - n;
        Node prev = head;
        int i = 1;// for traversal of the linked list with while loop
        while (i < idxToSearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;

    }

    // Merge two sorted linked list-->this approach is using recursion
    static Node mergeLL(Node l1, Node l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null)
            return l2;
        if (l1.data > l2.data) {
            l2.next = mergeLL(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeLL(l1.next, l2);
            return l1;
        }

    }

    // binary search
    static int binarSearch(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else
                return mid;
        }
        return -1;
    }

    // detect cycle
    static Node cycle(Node head) {
        if (head == null || head.next == null)
            return null;
        Node hare = head;
        Node turtle = head;
        return head;
    }

    // reverse a LinkedList
    static Node rev(Node head) {
        if (head == null || head.next == null)
            return head;
        Node newHead = rev(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }

    static int[] twoS(int arr[], int n, int k) {
        // using hashmap
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int rem = k - num;
            if (m.containsKey(rem))
                return new int[] { i, m.get(rem) };

            m.put(num, i);
        }
        return new int[] {};
    }

    static boolean isPalin(int n) {
        // check if a number is a palindrome or not
        if (n < 0)
            return false;// negative numbers can't be palindrome
        int temp = n, rev = 0;
        while (temp != 0) {
            int digit = (int) (temp % 10);// extracts last digit
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        return n == rev;
    }

    // print palindrome of a string
    public static void palinString(String s) {
        // given a string ,u have to print length of palindrome which can be made out of
        // the string
        String rev = reverse(s);
        int dp[][] = new int[s.length() + 1][rev.length() + 1];
        int res = lcs(s, rev, s.length(), rev.length(), dp);
        System.out.println(res);
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - i - 1;
            char frontCh = sb.charAt(front);
            char backCh = sb.charAt(back);
            sb.setCharAt(front, backCh);
            sb.setCharAt(back, frontCh);
        }
        return sb.toString();
    }

    static int lcs(String s, String t, int a, int b, int dp[][]) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a][b];
    }

    // find all the duplicates in an array
    static ArrayList<Integer> findDup(int arr[]) {
        Set<Integer> seen = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i : arr) {
            if (seen.contains(i)) {
                if (!res.contains(i)) {
                    res.add(i);
                }
            }
            seen.add(i);
        }
        return res;
    }

    // minimum cost of ropes
    static long minCost(long arr[]) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i : arr) {
            pq.add(i);
        }
        long cost = 0;
        while (pq.size() > 1) {
            long min1 = pq.remove();
            long min2 = pq.remove();
            cost = cost + min1 + min2;
            pq.add(min1 + min2);
        }
        return cost;
    }

    // finding intersection of two arrays
    static int[] inter(int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            if (set.contains(i)) {
                intersect.add(i);
            }
        }
        int res[] = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            res[i++] = num;
        }
        return res;
    }

    // Quick sort of an array
    // 1.choose a pivot
    // 2.partitioning according to the pivot
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int idx = low - 1;// initialising original pivot index

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                idx++;// if element is lesser,pivot idx incremented
                // then swaped
                int temp = arr[idx];
                arr[idx] = arr[i];
                arr[i] = temp;
            }
        }
        idx++;
        int temp = arr[idx];
        arr[idx] = pivot;
        arr[high] = temp;
        return idx;// we got original pivot index
    }

    static void quicksort(int arr[], int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            quicksort(arr, low, pidx - 1);
            quicksort(arr, pidx + 1, high);
        }
    }

    public static void main(String[] args) {
        // String s = "abgdbghb";
        // palinString(s);
        // int ar[] = { 1, 3, 4, 5, 7 };
        // int k = 58;
        // System.out.println(binarSearch(ar, k));
        int arr[] = { 1, 2, 8, 3, 4, 0 };
        // System.out.println(minCost(arr));
        quicksort(arr, 0, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}