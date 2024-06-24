package localrepo.Algorithm;

/*KADANE'S ALGO: It is a dynamic programming technique used to find the max sum of a 
 * contigous subarray within a 1d array of nos.
 */
public class kadane {
    public static int maxSubarraySum(int[] nums) {
        int max = nums[0];
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr = curr + nums[i];
            max = curr > max ? curr : max;
            if (curr < 0)
                curr = 0;

        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = { 1, -2, 4, 3, -3, 6, 7 };
        int max = maxSubarraySum(nums);
        System.out.println(max);
    }
}
