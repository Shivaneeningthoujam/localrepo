package localrepo.SearchingSorting;

import java.util.*;

public class permuteArrs {
    public static boolean isPossible(Integer a[], int b[], int n, int k) {
        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            if (a[i] + b[i] > k)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer a[] = { 2, 1, 3, 4 };
        int b[] = { 7, 8, 9 };
        int k = 10;
        int n = a.length;

        if (isPossible(a, b, n, k))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
