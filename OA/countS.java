// package localrepo.OA;

public class countS {
    // perform count sort to sort an array
    static int[] count(int ip[]) {
        int n = ip.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ip[i]);
            // we got the max element
        }
        // create a new count array
        int count[] = new int[max + 1];
        // store the frequency of elements
        for (int i = 0; i < n; i++) {
            count[ip[i]]++;
        }
        // now store cumulative frequencies
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        // make another result array with same size as the input
        int res[] = new int[n];
        // traverse the array from left to right
        for (int i = n - 1; i >= 0; i--) {
            res[count[ip[i]] - 1] = ip[i];
            count[ip[i]]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 4, 1, 1, 0, 9 };
        int res[] = count(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
