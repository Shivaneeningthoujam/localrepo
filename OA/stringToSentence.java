
public class stringToSentence {
    // we are given a string and have to convert it to equivalent sequence of number
    static String seq(String arr[], String ip) {
        // arr-->array of strings of number sequence of eac letter
        // ip-->input
        String op = "";// create a String to store the output
        for (int i = 0; i < ip.length(); i++) {
            if (ip.charAt(i) == ' ') {
                op = op + "0";
            } else {
                int idx = ip.charAt(i) - 'A';
                op = op + arr[idx];
            }
        }
        return op;
    }
}
