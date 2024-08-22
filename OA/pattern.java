package localrepo.OA;

/*
i/p: 4
o/p: 1
       2*3
       4*5*6
       7*8*9*10
*/
public class pattern {
    public static void main(String[] args) {
        printP(4);
    }

    public static void printP(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(count);
                if (j < i) {
                    System.out.print("*");
                }
                count++;
            }
            System.out.println();
        }
    }
}
