package localrepo.recursion;

//We are to find if a given array iis sorted or not using recursion
public class sorted {
    public static boolean isSorted(int[] arr, int idx) {
        // base case:If the index reaches the end ,its true
        if (idx == arr.length - 1)
            return true;

        return arr[idx] < arr[idx + 1] && isSorted(arr, idx + 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int[] arr1 = { 5, 3, 2 };
        boolean a = isSorted(arr, 0);
        boolean a1 = isSorted(arr1, 0);
        System.out.println(a);
        System.out.println(a1);
    }
}
