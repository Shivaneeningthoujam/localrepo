package localrepo.Arrays;

import java.util.*;

//Anagram : are the words that has different meaning of different arrangements of characters.
//eg: egg and geg
//The time complexity of this approach is O(m.nlogn)
public class groupAnagram {
    public static List<List<String>> groupAnag(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String w : strs) {
            char[] chars = w.toCharArray();
            // sort the array of characters u got
            Arrays.sort(chars);
            // Converted the sorted arrays back to strings
            String sortedW = new String(chars);
            // Check if the sortedWord is already in the map as key
            if (!map.containsKey(sortedW)) {
                // if not,create a new list for this group of anagrams
                map.put(sortedW, new ArrayList<>());
            }
            // Add the original word to the list of its anagram grp
            map.get(sortedW).add(w);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String str[] = { "hi", "ih", "hel", "leh" };
        List<List<String>> res = groupAnag(str);
        res = groupAnag(str);
        for (List<String> group : res) {
            System.out.print("[" + group + "]");
        }
    }

}