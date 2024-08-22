package localrepo.DP;

public class palindromSubseq {
    // Given a String and we have to find the length longest palindromic subsequence
    // 1.Find the reverse of S.
    // 2.Find the LCS of S and rev(S)

    public static void main(String[] args) {
        String S = "bbbab";
        palinSubseq(S);// Output is bbbb=4
    }

    static void palinSubseq(String S) {
        String s = rev(S);
        int res = lcs(S, s);
        System.out.println("The length of the longest palindromic subsequence is: " + res);
    }

    // Function to find the Longest Common Subsequence (LCS) of two strings
    static int lcs(String S, String s) {
        int m = S.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The LCS length of S and its reverse is the longest palindromic subsequence
        return dp[m][n];
    }

    // Function to reverse a string
    static String rev(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - 1 - i;
            char frontCh = sb.charAt(front);
            char backCh = sb.charAt(back);
            sb.setCharAt(front, backCh);
            sb.setCharAt(back, frontCh);
        }
        return sb.toString();
    }
}
