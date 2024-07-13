package localrepo.Algorithm;

public class binarySearch {
    // Constructing the algorithm of binary Search. Basically finding an element in
    // an array. It is more efficient than linear search
    // TIME-COMPLEXITY: O(log n)
    /*
     * STEPS
     * 1. Set start=0 and end as the last index
     * 2. find mid = start + (end - start) / 2
     * 3. compare target and mid element
     */
    public static int search(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // when you find the target
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int target = 5;
        int result = search(arr, target);
        System.out.println("result: " + result);
    }
}
