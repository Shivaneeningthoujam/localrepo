package localrepo.recursion;

//we will be given a rotated sorted array and a target to find in the array
//Here we are using the recursion method
public class rotatedBS {
    public static int search(int arr[], int target, int s, int e) {
        // Base case:if the start index is greater than the end index
        if (s > e)
            return -1;
        int m = s + (e - s) / 2;
        // if the middle element is the target,return its index
        if (arr[m] == target)
            return m;
        // if the left half is sorted
        if (arr[s] <= arr[m]) {
            // if the target is within the sorted left half,recursive search in the left
            // half
            if (target >= arr[s] && target <= arr[m]) {
                return search(arr, target, s, m - 1);
            } else {
                // otherwise ,search in the right half
                return search(arr, target, m + 1, e);
            }
        }
        // if the right half is sorted
        if (target >= arr[m] && target <= arr[e]) {
            // if the target is within the sorted right half,recursively search in the right
            // half
            return search(arr, target, m + 1, e);
        }
        // otherwise search in the left half
        return search(arr, target, s, m - 1);
    }
}
