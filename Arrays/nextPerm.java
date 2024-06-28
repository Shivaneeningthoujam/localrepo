package localrepo.Arrays;

public class nextPerm {
    public void nextPerm(int[] arr) {
        int ind1 = -1, ind2 = -1;
        // 1.Find the breaking point
        // BREAKING POINT:Traverse the array from right to left to find the 1st element
        // i.e smaller than element to its right
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind1 = i;// breaking point
            }
        }
        // If there is no such breaking point that means the array is sorted in
        // descending order
        // And we reverse the whole arr to get the smallest permutation
        if (ind1 == -1) {
            reverse(arr, 0);
        } else {
            // find next greater element and swap with ind2
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > arr[ind1]) {
                    ind2 = i;
                    break;
                }
            }
            swap(arr, ind1, ind2);
            // Reverse the rest right half
            reverse(arr, ind1 + 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void reverse(int[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };

    }
}
