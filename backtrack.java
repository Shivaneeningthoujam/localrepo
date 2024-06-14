package localrepo;
//Here we are going to write a program for backtracking where we will arrange how the 3 children A,B,C 

//can be seated in three seats __,__,__
//Permutation=n!=3!=6

public class backtrack {
    public static void printPerm(String str, String perm, int idx) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, perm + currChar, idx + 1);
        }
    }

    public static void main(String[] args) {
        String str = "efg";
        printPerm(str, "", 0);
    }

}
