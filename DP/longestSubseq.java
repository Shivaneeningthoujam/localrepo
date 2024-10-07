package localrepo.DP;

//We are given two strings and we are to find the longest common subsequent possible
//Eg: s=abcdef,t=abefgh --> o/p: r=abef
public class longestSubseq {
    // The efficent approach with Dynamic programming
    static int lcs(int m, int n, String a, String b) {
        int dp[][] = new int[m + 1][n + 1];
        // fill every cell with the value of -1
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsUtil(m, n, a, b, dp);
    }

    // top down approach
    private static int lcsUtil(int m, int n, String a, String b, int[][] dp) {
        // Base case:
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1) {
            // it means we got an answer so return that
            return dp[m][n];
        }
        if (a.charAt(m - 1) == b.charAt(n - 1)) {// if we got common value of substring
            return dp[m][n] = 1 + lcsUtil(m - 1, n - 1, a, b, dp);
        } else {
            return dp[m][n] = Math.max(lcsUtil(m, n - 1, a, b, dp), lcsUtil(m - 1, n, a, b, dp));
        }
    }

    // SECOND APPROACH:We use a tabular method
    static int lcsUtil2(int m, int n, String a, String b, int dp[][]) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
