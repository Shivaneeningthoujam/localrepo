package localrepo.OA;

import java.util.*;

public class string {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Read the entire line including spaces
        String ip = s.nextLine();
        // Remove white spaces from the string
        String noSpaces = ip.replace(" ", "");

        // Calculate the length of the string without white spaces
        int len = noSpaces.length();
        // Display the results
        System.out.println(len);

        // Close the scanner
        s.close();

    }
}
