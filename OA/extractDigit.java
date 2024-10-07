public class extractDigit {
    // given an integer . We are to return the extracted digits of the number
    static void separateDigit(int num) {
        int rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        while (rev > 0) {
            int dig = rev % 10;
            System.out.print(dig + " ");
            rev /= 10;
        }
    }

    // Happy number: check if a given num is happy. A number is happy if the sum of
    // square of its digits give 1
    static boolean isHappy(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = sq(num);
            fast = sq(sq(num));
        } while (slow != fast);
        return slow == 1;
    }

    static int sq(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 137;
        separateDigit(n);
    }

}
