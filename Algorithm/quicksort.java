package localrepo.Algorithm;

//Here ,we first select a pivot
//A pivot can be selected based on:
/*1.first element
* 2.last element
* 3.Median
* 4.Random no.
*/
//Then we perform partition bsed on the selected pivot.If an element is > pivot-->element comes after
//the pivot else before the pivot
public class quicksort {
    public static void quick(int arr[], int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);// getting the pivot index
            quick(arr, low, pidx - 1);
            quick(arr, pidx + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];// In this algo,we selected the last element as the pivot
        int i = low - 1;// i is the count of how many el before pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Keeping the pivot in the right position after arranging all the other
        // elements
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;// i is the pivot index
    }

    public static void main(String[] args) {
        int arr[] = { 9, 4, 0, 5, 2, 3, 1 };
        quick(arr, 0, 6);
        System.out.println("After quick sorting:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " e");
        }
    }
}
