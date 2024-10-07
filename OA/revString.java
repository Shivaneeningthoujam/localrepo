package localrepo.OA;

//given a string ,reverse it
public class revString {
    static String revStr(String s) {
        if (s == null)
            return "";

        char[] s2 = s.toCharArray();
        for (int i = 0; i < s2.length / 2; i++) {
            char temp = s2[i];
            s2[i] = s2[s2.length - 1 - i];
            s2[s2.length - i - 1] = temp;
        }
        return new String(s2);
    }

    public static void main(String[] args) {
        String s = "jfbb";
        System.out.println(revStr(s));
    }
}
