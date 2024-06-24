package localrepo.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Q.We have to check if the array given has any duplicate element
public class duplicate {
    public static boolean dup1(int[] arr) {
        // This is brute force approach--> O(nlogn)
        Arrays.sort(arr);
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }

    public static boolean dup2(int[] arr) {
        // This is more efficient: Hashset -->O(n)
        Set<Integer> set = new HashSet<>();
        for (int i : set) {
            if (set.contains(i))
                return true;
            set.add(i);
        }
        return false;
    }
}
