package localrepo.String;

//given a string find all possible permutation using recursion
public class permutate {
    static void gen(String s, String res) {
        // if string is empty,print the result
        if (s.length() == 0)
            System.out.println(res);
        // generate all permutations by choosing each char one by one
        for (int i = 0; i < s.length(); i++) {
            char currCh = s.charAt(i);
            // get the remaining haracter after removing the currentChar
            String rem = s.substring(0, i) + s.substring(i + 1);
            gen(rem, res + currCh);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String res = "";
        gen(s, res);
    }
}
