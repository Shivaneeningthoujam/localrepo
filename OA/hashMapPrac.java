package localrepo.OA;

import java.util.*;

public class hashMapPrac {
    // Checking if an array is a subset of anotehr
    static boolean isSubset(int arr1[], int arr2[], int m, int n) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        // add one array into the map
        for (int i : arr1) {
            seen.put(i, seen.getOrDefault(i, 0) + 1);
        }
        // check the arr2
        for (int i : arr2) {
            if (!seen.containsKey(i) || seen.get(i) == 0) {
                return false;

            }
            seen.put(i, seen.get(i) - 1);
        }
        return true;
    }

    // get the elements which occured more than n/3 times
    static void major(int arr[]) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {

            map.put(i, map.getOrDefault(0, map.get(i)) + 1);
        }
        for (int k : map.keySet()) {
            if (map.get(k) > n / 3)
                System.out.println(k);
        }

    }

    // union of 2 arr. return the size of union without duplicate
    static int union(int a1[], int a2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : a1) {
            set.add(i);
        }
        for (int i : a2) {
            set.add(i);
        }
        return set.size();
    }

    // intersection of 2 arrays. return the elements in the intersected
    static int inter(int a1[], int a2[]) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : a1) {
            set.add(i);
        }
        for (int i : a2) {
            if (set.contains(i)) {
                res++;
            }
        }
        return res;
    }

    // Extracting digits from a number
    static void extNum(int num) {
        // reverse the num so that after extracting it give sthe correct order
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        // extracting
        while (rev > 0) {
            System.out.print(rev % 10 + " ");
            rev /= 10;
        }
    }

    // Happy number: are those whose sqared digits sum gives 1
    static boolean isHappyNum(int num) {
        int slow = num, fast = num;
        // do while loop so the loop runs atleast 1s
        do {
            slow = sq(slow);
            fast = sq(sq(fast));
        } while (slow != fast);
        return slow == 1;// num is happy only if slow is equal to 1
    }

    static int sq(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;

        }
        return ans;
    }

    // finding intersection of 2 arrays and returning the elements
    static int[] interhf(int arr1[], int arr2[]) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inters = new HashSet<>();
        for (int i : arr1) {
            set.add(i);
        }
        for (int i : arr2) {
            if (set.contains(i)) {

                inters.add(i);

            }
        }
        int res[] = new int[inters.size()];
        int i = 0;
        for (int j : inters) {
            res[i++] = j;
        }
        return res;
    }

    // Next permutation
    static void next(int arr[]) {
        // first find the breaking point if no breaking point means last permutation so
        // reverse the array
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < arr.length; i++) {
            // search froom right to left
            if (arr[i] < arr[i + 1]) {
                idx1 = i;
            }
        }
        // if no breaking point found
        if (idx1 == -1) {
            rev(arr);
        } else {
            // breaking point found
            // now search for an element slightly greater than breaking point
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[idx1]) {
                    idx2 = i;
                }
            }
            // now swap the two
            swap(arr, idx1, idx2);
        }

    }

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void rev(int arr[]){
        for(int i=0;i<arr.length;i++){
            arr[i]=arr[i-arr.length-1];7
        }
    }

    // find missing and repeating number
    static long[] find(int arr[]) {
        int n = arr.length;
        long Sn = (long) n * (n + 1) / 2;
        long S2n = (long) n * (n + 1) * (2 * n + 1) / 6;
        long S = 0, S2 = 0;
        for (int i = 0; i < arr.length; i++) {
            S += arr[i];
            S2 += (long) arr[i] * arr[i];
        }
        long val1 = S - Sn;
        long val2 = S2 - S2n;
        val2 = val2 / val1;// x+y: not using extra space
        long x = (val1 + val2) / 2;
        long y = x - val1;
        return new long[] { x, y };// returning w/o extra space
    }

    public static void main(String[] args) {
        // int a1[] = { 2, 3, 2, 1, 4, 6 };
        // int a2[] = { 2, 3, 2, 5, 6, 7 };
        // System.out.println(inter(a1, a2));
        // System.out.println(union(a1, a2));
        int num = 2354;
        extNum(num);
        System.out.println(isHappyNum(num));
    }
}
