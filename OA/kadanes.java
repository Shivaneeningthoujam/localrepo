package localrepo.OA;

//Finding Max sum of a subarray using Kadane's Algo-O(n)
public class kadanes {
    public static int kad(int arr[]) {
        int max = arr[0];
        int curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            max = curr > max ? curr : max;
            if (curr < 0) {
                curr = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(kad(arr));
    }
}
