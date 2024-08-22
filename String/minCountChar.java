package localrepo.String;

public class minCountChar {
    public static void main(String[] args) {
        String str = "aabbbccc";
        char arr[] = str.toCharArray();
        int temp[] = new int[256];// to store whole acii chars a-z,A-Z,0-9
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i]]++;// incrementing the freq of each unique char
        }
        int min = Integer.MAX_VALUE;
        for (int i = 255; i >= 0; i--) {
            if (temp[i] == 0)
                continue;// zero freq isn't considered
            min = Math.min(min, temp[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (min == temp[arr[i]]) {
                System.out.println(arr[i]);
                break;
            }
        }
    }
}
