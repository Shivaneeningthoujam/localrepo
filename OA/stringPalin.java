package localrepo.OA;

public class stringPalin {
    // given a string,see if it is a palindrome
    static boolean palin(String s) {
        char c[] = s.toCharArray();
        for (int i = 0; i < c.length / 2; i++) {

            if (c[i] != c[c.length - i - 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ib98ehi";
        System.out.println(palin(s));
    }
}
