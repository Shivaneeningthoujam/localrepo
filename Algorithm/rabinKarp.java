//Rabin Karp searching Algorithm:
//Here we try to search for a given pattern in the string given
package localrepo.Algorithm;

//This is done by finding hash vals of the pattern and every substring and they are matched
public class rabinKarp {
    // d=no. of chars in the jnput alphabet
    public static final int d = 256;

    // q=prime num
    static void search(String pat, String txt, int q) {
        int P = pat.length(), T = txt.length(), i, j;
        int p = 0;// to strore hash value of the pattern
        int t = 0;// to store hash value of the text
        int h = 1;
        // The value of h is pow(d,P-1)%q
        for (i = 0; i < P - 1; i++)
            h = (h * d) % q;

        // Calculate the hash val of pattern and 1st window of text
        for (i = 0; i < P; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        // Slide the pattern over text 1 by 1
        for (i = 0; i <= T - P; i++) {
            // if hash vals of pattern and text matches
            if (p == t) {
                // check chars one by one
                for (j = 0; j < P; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                    // if all matches
                    if (j == P)
                        System.out.println("Pattern is found at index " + i);
                    // Calculate hash val for next window of text
                    // remove leading digit,add trail digit
                    if (j < T - P) {
                        t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + P)) % q;
                    }
                    // we might get negative val of t,convert it to positive
                    if (t < 0)
                        t = (t + q);
                }
            }
        }
    }

    public static void main(String[] args) {
        // String pat = "ab";
        // String txt = "abcdabbab";

    }
}