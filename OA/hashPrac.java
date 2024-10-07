// package localrepo.OA;

import java.util.*;

public class hashPrac {
    // 1.Group Anagram
    public static List<List<String>> groupA(String s[]) {
        Map<String, List<String>> map = new HashMap();
        for (String word : s) {
            char ch[] = word.toCharArray();
            Arrays.sort(ch);
            String sortedWord = new String(ch);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            } else {
                map.get(sortedWord).add(word);
            }
        }
        return new ArrayList<>(map.values());
    }

    // 2.Intersection of 2 arrays
    static int[] intArr(int a1[], int a2[]) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i : a1) {
            seen.add(i);
        }
        for (int i : a2) {
            if (seen.contains(i)) {
                intersect.add(i);
            }

        }
        int[] res = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            res[i++] = num;
        }
        return res;
    }

    // Subarray sum equals k
    // we are given an array,find no. of times k sum has occured
    static int sumK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // the key stores the prefix sum, value stores the count of k sum occurence
        map.put(0, 1);// initialise the map. It handles the case when subarray itself equals k
        // from the start of array
        int sum = 0, count = 0;
        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // to find if a given array is a subset of another array
    static boolean isSubset(int arr1[], int arr2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : arr2) {
            if (!map.containsKey(i) || map.get(i) == 0)
                return false;
            map.put(i, map.get(i) - 1);
        }
        return true;
    }

    // Majority elements : Given an array.Find the elements which occurs more than
    // n/3 times
    static void majorEl(int arr[]) {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) > n / 3) {
                System.out.println(i);
            }
        }
    }

    // union of 2 arrays : return the no. of elements in AUB
    static int Union(int a1[], int a2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : a2) {
            set.add(i);
        }
        for (int i : a1) {
            set.add(i);
        }
        return set.size();
    }

    // intersection: return the no. of common elements
    static int Intersection(int a1[], int a2[]) {
        Set<Integer> set = new HashSet<>();
        for (int i : a1) {
            set.add(i);
        }
        int count = 0;
        for (int i : a2) {
            if (set.contains(i)) {
                count++;
                set.remove(i);
            }
        }
        return count;
    }

    // subarray sum =k
    // return how many of the set
    static int kSum(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // key:prefix sum val: count of sum
        map.put(0, 1);// initialisation: handles when the subset equals sum k
        int sum = 0;
        int count = 0;
        for (int num : arr) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int a1[] = { 1, 2, 4, 5, 6 };
        int a2[] = { 0, 1, 2, 7, 8, 3, 4 };
        System.out.println(Intersection(a1, a2));
    }
}
