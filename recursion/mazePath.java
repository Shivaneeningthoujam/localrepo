package localrepo.recursion;

//We are to count the number of paths available to go from (0,0) to (n,m)matrix which is a maze
//We can only move right or downwards
public class mazePath {
    public static int countPath(int i, int j, int n, int m) {
        // Base case 1:When reached the boundary and cannot move
        if (i == n || j == m)
            return 0;
        // Base case 2: WHen the destination required is reached i.e (n,m)
        if (i == n - 1 && j == m - 1)
            return 1;

        // Recursion for moving downwards
        int downPath = countPath(i + 1, j, n, m);
        // For moving right
        int rightPath = countPath(i, j + 1, n, m);

        return downPath + rightPath;

    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        int f = countPath(0, 0, n, m);
        System.out.println(f);
    }
}
