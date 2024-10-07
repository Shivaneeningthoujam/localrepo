package localrepo.OA;

import java.util.*;

//given two arrays ,we are to find the intersection point
public class arrIntersect {
    static int[] arrInt(int arr1[], int arr2[]) {
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
        // then convert the set to array
        int res[] = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            res[i++] = num;
        }
        return res;

    }

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 4, 5, 3, 3 };
        int arr2[] = { 2, 3, 4, 5, 6, 8, 9 };
        int res[] = arrInt(arr1, arr2);
        for (int i : res)
            System.out.print(i + " ");
    }
}
