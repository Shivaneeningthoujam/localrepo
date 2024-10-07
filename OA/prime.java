package localrepo.OA;

//function to check for prime numbers
public class prime {
    static boolean primeNo(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(primeNo(65334));
        System.out.println(primeNo(2));
        // now finding prime numbers within a range
        int low = 4, high = 45;
        System.out.println("The prime numbers between " + low + " and " + high + " :");
        for (int i = low; i <= high; i++) {
            if (primeNo(i))
                System.out.print(i + " ");
        }
        System.out.println();
        // finding sum of prime numbers within a range
        int sum = 0;
        for (int i = low; i <= high; i++) {
            if (primeNo(i))
                sum += i;
        }
        System.out.println("The sum of prime numbers within the range is " + sum);
    }
}
