package localrepo.Algorithm;

//Revise this properly
public class mergesort {
    public static void divide(int arr[], int si, int ei) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;// handles overflow compared to using si+ei/2
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1];// size=size of arr
        int idx1 = si;
        int idx2 = mid + 1, x = 0;
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx1])
                merged[x + 1] = arr[idx1++];
            else
                merged[x++] = arr[idx2++];
        }
        while (idx1 <= mid) {
            merged[x++] = arr[idx2++];
        }
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }
}
