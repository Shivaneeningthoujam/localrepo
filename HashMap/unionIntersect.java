package localrepo.HashMap;

import java.util.*;

//1.We are two find the numbeer of elements in the result of union of two arrays and the resultant cant contain 
//duplicate elements
public class unionIntersect {
    public static int union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        return set.size();
    }

    // 2.Find the number of elements in the intersection of two arrays
    public static int intersect(int arr1[], int arr2[]) {
        /*
         * 1.take one of the array and add it into the hashset
         * 2.check if the elements of the other array is present or not
         */
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int j = 0; j < arr2.length; j++) {
            if (set.contains(arr2[j])) {
                count++;
                set.remove(arr2[j]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4 };
        int arr2[] = { 1, 2, 5, 6, 7, 4 };
        int a = union(arr1, arr2);
        int b = intersect(arr1, arr2);
        System.out.println(a + " " + b);
    }
}
