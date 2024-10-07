package localrepo.DP;

public class knapDuplicate {
    // we are to perform 0/1 knapsack with duplicate items in it
    static int knap(int wt[], int val[], int n, int W) {
        int dp[] = new int[W + 1];
        for (int i = 0; i < n; i++) {
            for (int j = W; i >= wt[i]; j--) {
                dp[j] = Math.max(dp[j], val[i] + dp[j - wt[i]]);
            }
        }
        return dp[W];
    }

    // actual 0/1 knapsack practice
    static int knapsack(int wt[], int val[], int n, int W) {
        // wt[]--> weight array stores weight of each item
        // val[]--> profit of each item
        // n--> No. of items
        // W--> the max capacity
        // base case--> fill the array with zero
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                // we inculde the current weight if it is less than of equal to the capacity of
                // the current column
                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                } else {
                    // not included and we use the value of the above row
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }
}
