package localrepo.OA;

import java.util.*;

//from a given string ,print only lower case letters and digits
public class onlyLet {
    public static String remove(String S) {
        String clean = S.replaceAll("[^a-z0-9]", "");
        return clean;
    }
}
