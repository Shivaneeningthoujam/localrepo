package localrepo.binarySearch;

public class rotateBS {
    // Here we are to find a target element in a rotated sorted array
    // 1.we find the pivot which is the largest element of the sorted array
    static int Search(int nums[], int target) {
        int pivot = findPivot(nums);
        // if you didn't find the pivot =>The array is not rotated
        if (pivot == -1)
            // then do the normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);

        // pivot found->ubhave found 2 asecending sorted arrays
        if (nums[pivot] == target)
            return pivot;

        if (target >= nums[0])
            return binarySearch(nums, target, 0, pivot - 1);

        return binarySearch(nums, target, 0, pivot - 1);
    }

    static int binarySearch(int nums[], int target, int start, int end) {
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < mid) {
                end = mid - 1;
            }
            if (target > mid)
                start = mid + 1;

            return mid;
        }
        return -1;
    }

    static int findPivot(int nums[]) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // we got 4 cases to find the pivot
            // 1.When the mid element is greater than the next mid+1 element
            // nums[]={3 4 0 1 2}-->pivot is 4
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // 2.
            if (mid > start && nums[mid] < nums[mid - 1])
                return mid - 1;
            // 3.
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            } else {// 4.
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int target = 5;
        int res = Search(arr, target);
        System.out.println(res);

    }
}