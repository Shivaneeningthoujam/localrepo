package localrepo.Algorithm;

//Given an unsorted array ,sort it using counting sort
public class countingSort {
    static int[] countSort(int ip[]) {
        // traverse the array and find the maximum value element
        int n = ip.length;
        int Max = 0;// to store the max val
        for (int i = 0; i < n; i++) {
            Max = Math.max(Max, ip[i]);
        }
        int count[] = new int[Max + 1];// create a count arr with max+1 size
        // Store the frequeencies of element in count arr
        for (int i = 0; i < n; i++) {
            count[ip[i]]++;
        }
        // store the cumulative sum of the frequencies in the count array
        // gives position of the elements in sorted array
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        // create an array to store the sorted result
        int res[] = new int[n];
        // traverse the original array from the end
        for (int i = n - 1; i >= 0; i--) {
            res[count[ip[i]] - 1] = ip[i];
            count[ip[i]]--;
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 6, 4, 3, 0, 1 };
        int res[] = countSort(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
