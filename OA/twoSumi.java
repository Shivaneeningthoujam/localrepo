package localrepo.OA;

import java.util.*;

//Write a function that returns the number 
//of pairs of integers in an array whose sum is equal to a given target value.
//We returned the number of sets 
public class twoSumi {
    static int twoSum(int arr[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int rem = k - arr[i];
            if (map.containsKey(rem)) {
                count++;

            }
            map.put(arr[i], i);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 7, -1, 5 };
        int k = 6;
        int res = twoSum(arr, k);
        System.out.println(res);

    }
}
