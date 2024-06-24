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
        // Check for base case
        if (arr.length == 0 || m == 0) {
            return 0;
        }
        // 1.Sort the given array
        Arrays.sort(arr);
        // 2.Check if there are enough packets for the given window size
        if (arr.length - 1 < m) {
            return -1;
        }
        // 3.Initialise minimum difference to max integeer possible
        int min_diff = Integer.MAX_VALUE;
        // In Java, Integer.MAX_VALUE is a constant that holds the maximum value an int
        // can have. This value is 2,147,483,647 (or 2^31 - 1).
        for (int i = 0; i < arr.length; i++) {
            // Calculate the ending index of the current window
            int nextWindow = i + m - 1;
            // Break if the window goes beyond the bounds of the array
            if (nextWindow >= arr.length)
                break;
            // Calculate the difference between the last and the first elements in the
            // window
            int diff = arr[nextWindow] - arr[i];
            // Update the min diff if found
            min_diff = Math.min(min_diff, diff);
        }
        // Return the calculated min diff
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
