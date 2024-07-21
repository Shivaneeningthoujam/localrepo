package localrepo.binarySearch;

class peakInd {
    // We are given a mountain of array.We are to find its peak element
    // arr[0 1 2 1 0]-->o/p=2\
    // We are using Binary search approach here
    public static int peak(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // Means we are in the decreasing part of the array [right part]
                // This may be the answer but still look left part
                // this is why end!=mid-1
                end = mid;
            } else {
                // ascending part of the array
                start = mid + 1;// bcz we know mid+1 elemnt >mid element
            }
        } // At the end ,start and end points to the largest element or the peak element
        return start;// return start or end as start = end
    }

    // Find an element in the mountain array
    public static int find(int arr[], int target) {
        int peak = peak(arr);
        int start = 0, end = arr.length - 1;
        int firstTry = orderAgnostic(arr, target, start, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        // else tru searching in the other half
        return orderAgnostic(arr, target, peak + 1, end);
    }

    // Order Agnostic Binary Search:Checking if a sorted array is in ascending or
    // descending order
    static int orderAgnostic(int arr[], int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ar[] = { 0, 1, 2, 3, 2, 1, 0 };
        int target = 2;
        int res = peak(ar);
        System.out.println(res);
        int find = find(ar, target);
        System.out.println(find);
    }
}