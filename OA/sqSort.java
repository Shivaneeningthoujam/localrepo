package localrepo.OA;

import java.util.Arrays;

//we are given an array,square and sort it
public class sqSort {
    static int[] sqSorta(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 3, 4 };
        sqSorta(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
