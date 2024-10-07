package localrepo.OA;

import java.util.*;

public class js {

    public static List<String> funWithAnagrams(List<String> text) {
        // A set to store unique sorted strings (anagram representatives)
        Set<String> seen = new HashSet<>();
        List<String> result = new ArrayList<>();

        // Iterate through each string in the input list
        for (String str : text) {
            // Convert the string to a char array, sort it, and make a string again
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            // If the sorted version is not seen before, add it to both the set and result
            if (!seen.contains(sortedStr)) {
                seen.add(sortedStr);
                result.add(str);
            }
        }

        // Sort the remaining strings alphabetically
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("code", "aaagmnrs", "doce");
        List<String> output = funWithAnagrams(input);

        for (String str : output) {
            System.out.println(str);
        }
    }
}
