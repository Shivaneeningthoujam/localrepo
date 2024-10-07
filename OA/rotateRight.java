package localrepo.OA;

import java.util.LinkedHashSet;

//given an array and an integer k. We are to rotate the array by k to the right
//eg: arr[]={1,2,3,4,5} , k=2 
//o/p: arr[]={4,5,1,2,3}
public class rotateRight {
    static void rotate(int arr[], int k) {
        int n = arr.length;
        rev(arr, 0, n - 1);// reverse the whole array
        rev(arr, 0, k - 1);// reverse the first k elements
        rev(arr, k, n - 1);// reverse the rest

    }

    static void rev(int arr[], int start, int end) {
        while (start < end) {// Note this small mistake
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            end--;
            start++;
        }
    }

    // to find the largest and the smallest in an array
    static void find(int arr[], int n) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Largest is: " + max);
        System.out.println("Smallest is: " + min);
    }

    // code to remove duplicate from a string
    static String remDup(String s) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        for (char ch : set) {
            res.append(ch);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3, 4, 5 };
        // find(arr, 5);
        // rotate(arr, k);
        // for (int i = 0; i < arr.length; i++) {
        // System.out.print(arr[i] + " ");
        // }
        String s = "proggramming";
        System.out.println(remDup(s));
    }
}
