package localrepo.Arrays;

public class Solution {
    public static long[] find2(int[] arr) {
        int n = arr.length;
        long Sn = (long) n * (n + 1) / 2;
        long S2n = (long) n * (n + 1) * (2 * n + 1) / 6;

        long S = 0, S2 = 0;
        for (int i = 0; i < n; i++) {
            S += arr[i];
            S2 += (long) arr[i] * arr[i];
        }

        long val1 = S - Sn;
        long val2 = S2 - S2n;
        val2 = val2 / val1; // x+y

        long x = (val1 + val2) / 2;
        long y = x - val1;

        return new long[] { x, y };
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 1 };
        long res[] = find2(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
