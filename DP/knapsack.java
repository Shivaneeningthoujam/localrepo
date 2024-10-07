package localrepo.DP;

public class knapsack {
    public static int Knap(int wt[], int val[], int n, int W) {
        int[][] dp = new int[n + 1][W + 1];// +1 as we include zero in both the col and row
        for (int i = 1; i <= n; i++) {// number of rows =number of elements in the weight array
            for (int w = 1; w <= W; w++) {// number of columns = Max capacity Given
                // if we include the item
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }

            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int capacity = 7;
        int n = values.length;

        System.out.println("Maximum value: " + Knap(weights, values, n, capacity)); // Output: 9
    }
}