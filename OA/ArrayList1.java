package localrepo.OA;

import java.util.*;

public class ArrayList1 {
    // k largest elements in array
    static int[] klarge(int arr[], int k) {
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

    // two sum but we are to return Arraylist
    static ArrayList<Integer> twoSum(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i];
            if (map.containsKey(rem)) {
                return new ArrayList<>();
            }
        }
    }

    // practicing methods of ArrayList.
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(0);
        // list.add(5);
        // list.add(3);
        // list.add(23);
        // // for (int i = 0; i < list.size(); i++) {
        // // System.out.print(list.get(i)+" ");
        // // }
        // for (int i : list) {
        // System.out.print(i + " ");
        // }
        int arr[] = { 12, 3, 4, 76, 0, 11 };
        int res[] = klarge(arr, 3);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
