package localrepo.OA;

import java.util.Scanner;

//Given an array A of size n,write a program that identifies the subarray form index x to index y
public class subarr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] A = new int[n];

        // Take input for the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        // Take input for the indices x and y
        System.out.print("Enter the starting index x: ");
        int x = scanner.nextInt();

        System.out.print("Enter the ending index y: ");
        int y = scanner.nextInt();

        // Validate the indices
        if (x < 0 || y >= n || x > y) {
            System.out.println("Invalid");
            throw new IllegalArgumentException("Invalid indices");
        } else {
            for (int i = x; i <= y; i++) {
                System.out.println(A[i] + " ");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
