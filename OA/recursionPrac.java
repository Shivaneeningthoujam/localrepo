package localrepo.OA;

import java.util.ArrayList;

public class recursionPrac {
    static String skip(String ip) {
        if (ip.isEmpty()) {
            return "";// if the string is empty,we return empty string
        }
        char ch = ip.charAt(0);// store the curr char at 0
        if (ch == 'a') {
            // if 'a ' found return other substring but a by skipping it
            return skip(ip.substring(1));
        } else
            // else keep iterating
            return ch + skip(ip.substring(1));
    }

    // code to skip a substring " apple"
    static String skipA(String ip) {
        if (ip.isEmpty())
            return "";
        if (ip.startsWith("apple"))
            return skipA(ip.substring(5));
        else
            return ip.charAt(0) + skipA(ip.substring(1));
    }

    // return subset
    static void subseq(String ip, String op) {
        if (ip.isEmpty()) {
            System.out.println(op);
            return;
        }
        char ch = ip.charAt(0);
        // either add the char
        subseq(ip.substring(1), op + ch);
        // or dont add at all
        subseq(ip.substring(1), op);
    }

    static ArrayList<String> subseqA(String ip, String op) {
        if (ip.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(op);
            return list;
        }
        char ch = ip.charAt(0);
        // Either add the character
        ArrayList<String> left = subseqA(ip.substring(1), op + ch);
        // or dont add
        ArrayList<String> right = subseqA(ip.substring(1), op);
        left.addAll(right);
        return left;
    }

    public static void main(String[] args) {
        String ip = "abc";
        String op = "";
        subseq(ip, op);

    }
}
