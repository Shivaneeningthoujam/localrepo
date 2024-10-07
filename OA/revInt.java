package localrepo.OA;

//we are to reverse a given Integer 32-bit x ,if reverrsing the x causes the value to go
//beyond signed 32 bit range(2^-31 to 2^31-1),return 0
//MEDIUM LEETCODE
public class revInt {
    public static int rev(int x) {
        int res = 0;
        while (x != 0) {
            int tail = x % 10;
            int newRes = res * 10 + tail;
            if ((newRes - tail) / 10 != res)
                return 0;
            res = newRes;
            x = x / 10;

        }
        return res;
    }
}
