package localrepo.OA;

import java.util.*;

//Given an integer array nums, return all the 
//triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
public class threeSum {
    public static List<List<Integer>> three(int nums[]) {
        // Make the list which is to be returned
        // NOTE THE SYNTAX
        Set<List<Integer>> res = new HashSet();
        if (nums.length == 0)
            return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));

                } else if (sum > 0)
                    k--;
                else if (sum < 0)
                    j++;
            }
        }
        return new ArrayList<>(res);

    }
}
