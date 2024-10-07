package localrepo.DP;

//practicing Longest common subsequence:We are to return the length of longest common subsequence that 
//can be formed
public class longSubseq {
  static int lcs(int m, int n, String a, String b) {
    int dp[][] = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        dp[i][j] = -1;
        // filled every array rows and cols with -1 except 1st row and 1st column
      }
    }
    return lcsUtil(m, n, a, b, dp);
  }

  // 1st approach: top down approach which is memoization
  static int lcsUtil(int m, int n, String a, String b, int dp[][]) {
    // base case because its a recursive approach
    if (m == 0 || n == 0)
      return 0;
    if (dp[m][n] != -1) {
      // we already had the ans of the cell
      return dp[m][n];
    }
    // if we see any common characters iin the two strings
    if (a.charAt(m - 1) == b.charAt(n - 1)) {
      dp[m][n] = 1 + lcsUtil(m - 1, n - 1, a, b, dp);
    } else
      dp[m][n] = Math.max(lcsUtil(m, n - 1, a, b, dp), lcsUtil(m - 1, n, a, b, dp));
    return dp[m][n];
  }

  // 2nd approach : We use tabular form which is faster and more efficient
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
