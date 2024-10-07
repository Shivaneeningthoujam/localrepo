package localrepo.OA;

import java.util.Arrays;

public class twosum {
    // hashmap gets optimized time complexity but it uses extra space
    // 1.sort
    // 2 pointer
    // 3 binary search
    static int twoSum(int arr[], int target) {// returns the index of the target
        Arrays.sort(arr);// O(log n)
        int i = 0, j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target > arr[mid])
                i = mid + 1;
            else if (target < arr[mid])
                j = mid - 1;
            else
                return mid;
        }
        return -1;
    }

}
