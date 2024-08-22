package localrepo.OA;

import java.util.*;

public class prac {
    // static int fibo(int n) {
    // if (n == 1 || n == 0) {
    // return 1;

    // }
    // return fibo(n - 1) + fibo(n - 2);
    // }

    static int[] twoSum(int arr[], int n, int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i] + arr[j] == k)
                    return new int[] { arr[i], arr[j] };
            }
        }
        return new int[] {};
    }

    static int[] twoS(int arr[], int n, int k) {
        // using hashmap
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int rem = k - num;
            if (m.containsKey(rem))
                return new int[] { i, m.get(rem) };

            m.put(num, i);
        }
        return new int[] {};
    }

    static boolean isPalin(int n) {
        // check if a number is a palindrome or not
        if (n < 0)
            return false;// negative numbers can't be palindrome
        int temp = n, rev = 0;
        while (temp != 0) {
            int digit = (int) (temp % 10);// extracts last digit
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        return n == rev;
    }

    // print palindrome of a string
    public static void palinString(String s) {
        // given a string ,u have to print length of palindrome which can be made out of
        // the string
        String rev = reverse(s);
        int dp[][] = new int[s.length() + 1][rev.length() + 1];
        int res = lcs(s, rev, s.length(), rev.length(), dp);
        System.out.println(res);
    }

    static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() / 2; i++) {
            int front = i;
            int back = sb.length() - i - 1;
            char frontCh = sb.charAt(front);
            char backCh = sb.charAt(back);
            sb.setCharAt(front, backCh);
            sb.setCharAt(back, frontCh);
        }
        return sb.toString();
    }

    static int lcs(String s, String t, int a, int b, int dp[][]) {
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= b; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[a][b];
    }

    public static void main(String[] args) {
        String s = "abgdbghb";
        palinString(s);
    }
}