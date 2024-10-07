package localrepo.OA;

import java.util.HashMap;

import localrepo.Algorithm.binarySearch;

//twoSum problem
public class twoSum2 {
    public static int[] twoSum(int nums[], int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem))
                return new int[] { i, map.get(rem) };
            map.put(nums[i], i);
        }
        return new int[] {};
    }

    static int[] two(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            // perform binary search to find the rem
            int ind = binarySearch(nums, rem, i + 1, nums.length - 1);
            if (ind != -1)
                return new int[] { i, ind };
        }
        return new int[] { -1, -1 };
    }

    static int binarySearch(int nums[], int target, int start, int end) {
        if (nums == null)
            return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6 };
        int target = 5;
        int res[] = two(nums, target);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
