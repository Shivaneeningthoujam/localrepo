package localrepo.greedyMethod;

import java.util.Arrays;

//you are given children and cookie array.Find the number of sets of students you can satisfy with the cookies
public class cookie {
    // we are using greedy method
    public static int find(int child[], int cookie[]) {
        int n = child.length;
        int m = cookie.length;
        int l = 0, r = 0;// two pointers left for children array and right for cookie array
        Arrays.sort(child);// O(nlogn)
        Arrays.sort(cookie);// O(mlogm)
        while (l < m && r < n) {
            // it might happen that children are very less,so
            // r might reach the end faster
            if (child[r] <= cookie[l]) {
                r = r + 1;
            }
            l = l + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        int child[] = { 1, 5, 3, 3, 4 };
        int cookie[] = { 4, 2, 1, 2, 1, 3 };
        System.out.println(find(child, cookie));
    }
}
