package localrepo.recursion;

//No. of ways of placing a tile of 1 x m on  n x m floor
public class tilePlacemnt {
    public static int placeTile(int n, int m) {
        // base case 1: if n==m ,only 2ways pssible
        if (n == m)
            return 2;
        // base case 2: if n<m only 1 way
        if (n < m)
            return 1;
        // vertical
        int vert = placeTile(n - m, m);
        // horizontal
        int hor = placeTile(n - 1, m);

        return vert + hor;
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int i = placeTile(n, m);
        System.out.println(i);
    }
}
