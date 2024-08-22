package localrepo.StacksQueues;

import java.util.Stack;

public class postfixExp {
    // Here we are given a postfix expression and we are to evaluate its value
    // i/p: "2 3 1 * + 9 -" o/p
    static int postEv(String s) {
        // 1st create Stack -iterate L-->R
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                st.push(c - '0');
            } else {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (c) {
                    case '*':
                        st.push(val2 * val1);
                        break;
                    case '+':
                        st.push(val2 + val1);
                        break;
                    case '-':
                        st.push(val2 - val1);
                        break;
                    case '/':
                        st.push(val2 / val1);
                        break;

                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String s = "231*+9-";
        int r = postEv(s);
        System.out.println(r);
    }
}
