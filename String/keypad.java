package localrepo.String;

import java.util.*;

//We are given a string of letters and we are to convert it into series of equivalent mobile
//numeric keypad sequencee
class keypad {
    public static String printSeq(String arr[], String inp) {
        String output = "";
        for (int i = 0; i < inp.length(); i++) {
            if (inp == " ")
                output += "0";
            else {
                int position = inp.charAt(i) - 'A';
                output += arr[position];
            }
        }
        return output;
    }

    public static void main(String[] args) {
        String str[] = { "2", "22", "222", "3", "33", "333",
                "4", "44", "444", "5", "55", "555",
                "6", "66", "666", "7", "77", "777",
                "7777", "8", "88", "888", "9", "99",
                "999", "9999" };

        String input = "GEEKSFORGEEKS";
        System.out.println(printSeq(str, input));
    }
}
