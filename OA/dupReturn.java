package localrepo.OA;

import java.util.*;

public class dupReturn {
    // given an array,find duplicates and return them
    public static ArrayList<Integer> dupli(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            // if already seen=>duplicate=>add to the res
            if (seen.contains(num)) {
                if (!res.contains(num)) {
                    res.add(num);
                }
            } else {
                seen.add(num);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 4, 0, 2, 3, 3, 3, 4 };
        ArrayList<Integer> res = dupli(arr, 6);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
