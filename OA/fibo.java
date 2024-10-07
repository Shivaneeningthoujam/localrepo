package localrepo.OA;

//give the fibo series of the given n
public class fibo {
    static int[] fibo(int n) {
        if (n == 0 || n == 1)
            return new int[] { n };
        int ans[] = new int[n];
        int a = 1, b = 1;
        for (int i = 2; i < n; i++) {
            ans[i] = a + b;// calculates with the above vals
            a = b;// a holds the prev b val
            b = ans[i];// b got update for next series
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int ans[] = fibo(7);
        for (int i = 0; i < ans.length; i++)
            System.out.println(ans[i]);
    }
}
