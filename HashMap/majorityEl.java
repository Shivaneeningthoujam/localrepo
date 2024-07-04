package localrepo.HashMap;

import java.util.*;

//We are to find the element in an array which occured more than [n/3]times 
//n=size of the array
class majorityEl {
    // 1.First we create a hashMap
    // 2.Find the frequencies of all the elements and store in the map
    public static void major(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i : arr) {
            if (map.get(i) > n / 3) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 2, 1, 4, 1, 5, 2 };
        major(arr, 10);
    }
}