package localrepo.OA;

public class nonRepChar {
    // return the first non repeating character
    static Character nonRep(String s) {
        int count[] = new int[26];// created an array count to store the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[s.charAt(i)] == 1)
                return ch;
        }
        return '$';
    }

    public static void main(String[] args) {
        String s = "Hidlsjd";
        System.out.println(nonRep(s));
    }

}
