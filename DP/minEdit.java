package localrepo.DP;

//The problem is we are to convert the other string into the first string or Vice versa using the least 
//possible number of operations 
//Operations we can perform are: 1.Delete 2.insertion 3.replace
//i/p:a b c a b and e a c b  o/p:3
public class minEdit {
    static int editDist(String a, String b) {
        int m = a.length();
        int n = b.length();
        // create a 2d array of dp
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            return dp[i][0] = i;
        for (int j = 0; j <= n; j++)
            return dp[0][j] = j;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "abcab";
        String b = "eacb";
        int r = editDist(a, b);
        System.out.println(r);
    }
}
