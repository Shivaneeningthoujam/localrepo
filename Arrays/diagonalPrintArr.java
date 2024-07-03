package localrepo.Arrays;

public class diagonalPrintArr {
    static final int R = 5, C = 4;

    // utility function to find min of 2 ints
    static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    // function to find min of 3 ints
    static int min(int a, int b, int c) {
        return min(min(a, b), c);
    }

    // function to find max of 2 ints
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // function to print the array
    static void printArr(int matrix[][]) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.println("\n");
        }
    }

    static void diagPrint(int matrix[][]) {
        // There will be R+C-1 output lines: common sence :)
        for (int line = 1; line < R + C - 1; line++) {
            int start_col = max(0, line - R);
            int count = min(line, (C - start_col), R);
            // print the elements in the line
            for (int j = 0; j < count; j++) {
                System.out.print(matrix[min(R, line) - j - 1][start_col + j] + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int M[][] = {
                { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }, { 13, 14, 15, 16 },
                { 17, 18, 19, 20 },
        };
        System.out.print("Given matrix is \n");
        printArr(M);

        System.out.print(
                "\nDiagonal printing of matrix is \n");
        diagPrint(M);
    }
}