package localrepo.String;
// Input: S = “geeksforgeeks”

// Output:

import java.util.HashMap;
import java.util.Map;

// e, count = 4
// g, count = 2
// k, count = 2
// s, count = 2
//Print the elements which occured more than once
public class duplicate {
    public static void printDupli(String inp) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < inp.length(); i++) {
            char c = inp.charAt(i);
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);

            else
                m.put(c, 1);
        }
        for (Map.Entry<Character, Integer> mapEl : m.entrySet()) {
            if (mapEl.getValue() > 1)
                System.out.println(mapEl.getKey() + ",count=" + mapEl.getValue());
        }
    }

    public static void main(String[] args) {
        String S = "geeksforgeeks";
        printDupli(S);
    }
}
