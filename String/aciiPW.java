package localrepo.String;

public class aciiPW {
    public static void main(String[] args) {
        String str = "796115110113721110141108";
        char arr[] = str.toCharArray();
        String curr = "";// hold a 2-3 char length string temporarily for manipulation
        String res = "";// holds the actual result
        // Iterating from back
        for (int i = arr.length - 1; i >= 0; i = i - 2) {
            curr = "";// renews everytime with new iteration
            curr = "" + arr[i] + arr[i - 1];// store the last two chars in the curr as string temporarily
            int n = Integer.parseInt(curr);// convert the string curr into an integer
            if (n == 32)
                res += " ";
            else if ((n >= 65 && n <= 90) || (n >= 97 && n <= 99))
                res += (char) n;
            else {
                if (i - 2 < 0)// break if there's less than 2 chars
                    break;
                curr += arr[i - 2];// now include the above 1 char to form 3chars
                n = Integer.parseInt(curr);
                res += (char) n;
                i--;
            }
        }
        System.out.println(res);
    }

}
