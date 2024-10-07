package localrepo.OA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // rotate arr by k to the rigt
    static void rot(int arr[], int k) {
        rev(arr, 0, arr.length - 1);// reverse the whole array
        rev(arr, 0, k - 1);// reverse the first k elements
        rev(arr, k, arr.length - 1);// reverse the rest
    }

    static void rev(int arr[], int s, int e) {
        while (s < e) {
            int temp = s;
            s = e;
            e = temp;
            s++;
            e--;
        }
    }

    // kadane's algorithm to find max subarray sum
    static int kadsh(int num[]) {
        int curr = 0, max = num[0];
        for (int i = 0; i < num.length; i++) {
            curr += num[i];// stores sum of consecutive elements in the array
            max = curr > max ? curr : max;
            if (curr < 0)
                curr = 0;
        }
        return max;
    }

    // next permutation of a givern array
    static void nextPerm(int num[]) {
        // 1.find breaking point
        int idx1 = -1;
        int idx2 = -1;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                idx1 = i;
                break;// NOTE THIS BIYOTCH!!!
            }
        }
        if (idx1 == -1) {
            rev(num, 0);
        } else {
            // find slightly greater element than breaking point
            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] > num[idx1]) {
                    idx2 = i;
                    break;//
                }
            }
            swap(num, idx1, idx2);
            rev(num, idx1 + 1);
        }

    }

    static void swap(int num[], int i, int j) {
        // swap idx1 and idx2
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    static void rev(int num[], int start) {
        int i = start, j = num.length - 1;
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }

    // Group anagram
    static List<List<String>> groupAna(String str[]) {
        // create a map of string,list of string
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            // convert the string to char array then sort the array
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            // convert the array back to a string
            String sortedWord = new String(ch);
            // now check map
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(s);
        }
        return new ArrayList<>(map.values());
    }

    // Checking if a string is a palindrome
    static boolean isPalin(String a) {
        int i = 0, j = a.length() - 1;
        while (i <= j) {
            if (a.charAt(i) != a.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        // int arr[] = { 6, 0, 1, 5, 2 };
        // // System.out.println(kad(arr));
        // // remDup(arr);
        // // rev(arr);
        // // int res[] = bigSmall(arr);
        // // for (int i : res) {
        // // System.out.println(i);
        // // }
        // nextPerm(arr);
        // for (int i : arr) {
        // System.out.print(i + " ");
        // }
        String a = "ibobi";
        System.out.println(isPalin(a));
    }
}
