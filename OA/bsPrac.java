package localrepo.OA;

public class bsPrac {
    // to find a letter greater than the target
    static char find(char arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return arr[start % arr.length];
    }

    // find the range of occurence of an element in an array
    public static int[] findRange(int arr[], int target) {
        int ans[] = { -1, -1 };
        ans[0] = search(arr, target, true);
        if (ans[0] != -1) {
            ans[1] = search(arr, target, false);
        }
        return ans;
    }

    static int search(int arr[], int target, boolean findFirst) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // potential answer
                ans = mid;
                if (findFirst == true) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return ans;
    }

    // find peek of the mountain array
    static int findPeek(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // identifying which is the asc and desc part
            if (arr[mid] > arr[mid + 1]) {
                // u r in desc part
                // this may be the ans but keep looking
                end = mid;
            } else {
                // ascending part
                start = mid + 1;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        // int arr[] = { 0, 0, 0, 0, 0, 1, 2, 3, 3 };
        int arr[] = { 0, 1, 2, 1, 0 };
        // int target = 0;
        // int res[] = findRange(arr, target);
        // for (int i : res) {
        // System.out.print(i + " ");
        // }
        System.out.println(findPeek(arr));
    }
}
