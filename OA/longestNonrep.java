package localrepo.OA;

import java.util.HashMap;

class longestNonrep {
    // we are given a string and we have to find the length of the longest non
    // repeating substring
    static int longes(String s) {
        // we are using two pointers and a hashmap
        int left = 0;// fixed pointer at first
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        // iterate the array using right pointer
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            // check if the curr char is already in the map and the curr window
            if (map.containsKey(curr) && map.get(curr) >= left) {
                // Move left to the right of the previous occurence (+1)
                left = map.get(curr) + 1;
            }
            // update the char's position in the map
            map.put(curr, right);
            // calculate the max length of the window
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longes(s));
    }
}