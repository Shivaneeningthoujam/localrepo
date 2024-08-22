package localrepo.OA;

import java.util.Scanner;

//given a String ,we are to remove the vowels and return the remaining
public class removeVowel {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String S = s.nextLine();// nextline also counts the spaces in the string
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'a' || S.charAt(i) == 'e' || S.charAt(i) == 'i' || S.charAt(i) == 'o'
                    || S.charAt(i) == 'u' || S.charAt(i) == 'A' || S.charAt(i) == 'E' || S.charAt(i) == 'I'
                    || S.charAt(i) == 'O' || S.charAt(i) == 'U') {
                continue;
            } else {
                System.out.print(S.charAt(i));
            }
        }
    }
}
