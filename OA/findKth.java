package localrepo.OA;

import java.util.*;

public class findKth {
    // given an array ,we are to find the kth smallest element
    static int findK(int arr[], int k) {// O(nlogn)-as it adds all the element ,less efficient so use Max heap
        // we use min heap
        // add all elements in the min heap
        // remove 1st k-1 elements then return peek
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
        for (int i = 0; i < k - 1; i++) {// we have to return the (k-1)th element so poll untill (k-2)th element
            pq.poll();
        }
        return pq.peek();
    }

    static int findK2(int arr[], int k) {
        // Using Max heap
        // we don't add all the elements ,we add the reqd elements only
        // InitialisMaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // Add the first k elements into the heap
        for (int i = 0; i < k; i++) {
            pq.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }

        }
        return pq.peek();
    }

    // this is to find kth largest element in the array
    static int findK3(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }
        for (int i = 0; i < k - 1; i++)
            pq.poll();
        return pq.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 3, 20, 15 };
        // 3,4,7,10,15,20
        int k = 3;
        int r = findK3(arr, k);
        System.out.println(r);
    }
}
