package localrepo.DP;

import java.util.*;

public class segmentArr {

    public int minSegmentCost(int[] arr, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        dp[0][0] = 0;

        int[][] cost = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> lastOccurrence = new HashMap<>();
            int currentCost = 0;
            for (int j = i; j < n; j++) {
                int num = arr[j];
                if (lastOccurrence.containsKey(num)) {
                    currentCost += j - lastOccurrence.get(num);
                }
                lastOccurrence.put(num, j);
                cost[i + 1][j + 1] = currentCost;
            }
        }

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                for (int l = 0; l < i; l++) {
                    if (dp[l][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + cost[l + 1][i]);
                    }
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        segmentArr sol = new segmentArr();
        int n = 7;
        int k = 2;
        int[] arr = { 1, 6, 6, 4, 6, 6, 6 };
        System.out.println(sol.minSegmentCost(arr, n, k)); // Output should be 3
    }
}
