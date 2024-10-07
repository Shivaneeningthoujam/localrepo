package localrepo.Arrays;

//BOYER_MOORE VOTING ALGO:
//The algorithm finds the majority element like in an election
//Majority element: Elements which occurs more than n/2
public class boyerMoore {
    static int majority(int arr[]) {
        // choose a random candidate usually arr[0] and set its count to 1
        int candidate = arr[0];
        int count = 1;
        // start iterating from i=1
        for (int i = 1; i < arr.length; i++) {
            // if you find identical element increase the count else decrease the count
            if (candidate == arr[i])
                count++;
            else
                count--;
            // if the count is 0, change the candidate
            if (count == 0) {
                candidate = arr[i];
                // and reset count to 1 again
                count = 1;
            }
        }
        count = 0;// reset count again to 0 to reuse it again
        // Phase 2: Verifying if the candidate we got is actually the majority element
        for (int i : arr) {
            if (i == candidate)
                count++;
        }
        return (count > arr.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
        System.out.println(majority(arr));
    }
}
