package localrepo.recursion;

//Given an array and a target .We need to find the target in the array using recursing
public class linearSearch {
    // function to tell if the target exist in the array
    public static boolean found(int[] arr, int k, int idx) {
        if (idx == arr.length)// If the search lands outside the array...false:Base case
            return false;

        return arr[idx] == k || found(arr, k, idx + 1);
    }

    // function to return the index of the target if found in the array
    public static int Index(int[] arr, int k, int idx) {
        if (idx == arr.length)// If the search lands outside the array...false:Base case
            return -1;
        if (arr[idx] == k)
            return idx;

        return Index(arr, k, idx + 1);

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7 };
        int k = 2;
        boolean f = found(arr, k, 0);
        int g = Index(arr, k, 0);
        System.out.println(f);
        System.out.println(g);

    }
}
