package localrepo.DP;

public class lcsPrc {
    // finding the length of the longest common subsequence in the two given strings
    static int lcsUtil(int m, int n, String a, String b, int dp[][]) {
        // ApPROACH: base case , if already found , char matched ,char not matched
        // base case
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            // answer already found
            return dp[m][n];
        }
        if (a.charAt(m) == b.charAt(n)) {
            dp[m][n] = 1 + lcsUtil(m - 1, n - 1, a, b, dp);
            return dp[m][n];
        } else {
            // not matched
            dp[m][n] = Math.max(lcsUtil(m - 1, n, a, b, dp), lcsUtil(m, n - 1, a, b, dp));
            return dp[m][n];
        }
    }

    static int lcs(int m, int n, String a, String b) {
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsUtil(m, n, a, b, dp);
    }
    // tabular method-bot up
    // if the char matches ,diag+1
    // not then max of left and upper val
}
