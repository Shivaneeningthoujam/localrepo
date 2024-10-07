// package localrepo.OA;

import java.util.Arrays;
import java.util.PriorityQueue;

public class heap {
    // we are to find the k largest elements
    static int[] kLarge(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        int res[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }

    // key pair : given an x, find if the sum of a pair of elemts equals x
    static boolean find(int arr[], int x) {
        Arrays.sort(arr);
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == x)
                return true;
            else if (arr[start] + arr[end] > x)
                end--;
            else
                start++;
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 4, 3, 8, 9, 0 };
        int k = 3;
        int res[] = kLarge(arr, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println(find(arr, k));
    }
}
