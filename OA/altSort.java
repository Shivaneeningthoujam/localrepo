package localrepo.OA;

//given an unsorted array.Sort it .Return alternate result
//i/p:4 3 2 5 7
//o/p:2 4 7
public class altSort {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 2, 5, 7 };
        // bubble sort
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // printing
        for (int i = 0; i < arr.length; i = i + 2) {
            System.out.print(arr[i] + " ");
        }
    }
}
