package localrepo.Arrays;

import localrepo.Algorithm.binarySearch;

public class minRotated {
    // we are given a rotated array and we have to return the min of the array
    public static int findMin(int arr[]) {
        int left = 0, right = arr.length - 1;
        if (left < right)
            return arr[left];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // check if mid element is greater than the last element
            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 1, 2, 3 };
        System.out.println("Index of the min element is " + findMin(arr) + " and the element is " + arr[findMin(arr)]);// returns
                                                                                                                       // the
                                                                                                                       // index
                                                                                                                       // of
                                                                                                                       // the
                                                                                                                       // min
                                                                                                                       // element
    }
}