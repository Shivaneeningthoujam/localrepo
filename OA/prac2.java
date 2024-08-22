package localrepo.OA;

public class prac2 {
    // reverse the elements of an array
    static void rev(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int front = i;
            int back = n - 1 - i;
            int temp = arr[front];
            arr[front] = arr[back];
            arr[back] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int[] bigSmall(int arr[]) {
        int n = arr.length;
        // bubble sort
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return new int[] { arr[0], arr[n - 1] };
    }

    // remove duplicate from a sorted array
    static void remDup(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1])
                System.out.println(arr[i] + " is the duplicate element");
        }
    }

    // KADANE"S ALGO:used to find max subarray sum,a dynamic programming technique
    static int kad(int arr[]) {
        int max = arr[0], curr = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            max = curr > max ? curr : max;
            if (curr < 0)
                curr = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 4, 4, 5 };
        System.out.println(kad(arr));
        // remDup(arr);
        // rev(arr);
        // int res[] = bigSmall(arr);
        // for (int i : res) {
        // System.out.println(i);
        // }
    }
}
