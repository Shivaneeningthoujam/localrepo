package localrepo;

import java.util.*;

public class parenCheck {

    // Parenthesis checker:Check if the parenthesis are in order
    public static boolean parenChec(String str) {
        Stack<Character> st = new Stack<>();
        // push opening brackets ,but pop when u come across clossing bracket(pop the
        // corresponding pair )
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
                continue;
            }
            // closing bracket
            if (st.isEmpty()) {
                return false;
            }
            char check;
            switch (ch) {
                case ')':
                    check = st.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = st.pop();
                    if (check == '[' || check == '(')
                        return false;
                    break;

                case ']':
                    check = st.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;

            }

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String st = "[{}()]";
        boolean f = parenChec(st);
        System.out.println(f);
    }
}
