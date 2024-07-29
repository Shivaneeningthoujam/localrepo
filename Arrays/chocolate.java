package localrepo.Arrays;

import java.util.Arrays;

public class chocolate {
    // Chocolate Distribution problem
    // Given an array of N integers where each value represents the number of
    // chocolates in a packet. Each packet can have a variable number of chocolates.
    // There are m students,
    // the task is to distribute chocolate packets such that:
    // Each student gets one packet.
    // The difference between the number of chocolates in the packet with maximum
    // chocolates and the packet with minimum chocolates given to the students is
    // minimum.
    public static int chocoDist(int[] arr, int m) {
        // Check for base case:if the length of the array or m is 0,return 0
        if (arr.length == 0 || m == 0)
            return 0;
        // Sort the array
        Arrays.sort(arr);
        // see if there are enough m packets in the array
        if (arr.length - 1 < m)
            return -1;

        // initialise the minimum value
        int min_diff = Integer.MIN_VALUE;

        // iterate throught the array to find the subsets
        for (int i = 0; i < arr.length; i++) {
            int windowEnd = i + m - 1;// m is given which is the number of packets to be distributed
            // break if the window goes beyond the bounds
            if (windowEnd >= arr.length)
                break;
            // calculate the difference between the first and last element of the window
            int diff = arr[windowEnd] - arr[i];
            // select the minimum difference to return
            min_diff = Math.min(min_diff, diff);
        }
        return min_diff;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 3, 4, 7, 23, 25, 42 };
        int m = 5;
        int result = chocoDist(arr, m);
        if (result != -1) {
            System.out.println("Minimum difference is " + result);

        } else {
            System.out.println("Invalid input!");
        }
    }
}
