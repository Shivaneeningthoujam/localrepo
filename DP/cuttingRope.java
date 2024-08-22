package localrepo.DP;
//we are given an array of prices and lengths in which ropes can be cut,which is 1-n

public class cuttingRope {
    public static int cutRod(int price[], int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], price[j] + dp[i - j - 1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 5, 4, 7 };
        System.out.println(cutRod(arr, 5));
    }
}
