package localrepo.OA;

import java.util.LinkedList;
import java.util.Queue;

//we are to return the stepping sumbers of a given range
//Stepping Number: The number whose adjacent digits have difference of exactly one
//i/p:121,232,543
public class steepingNum {
    public static void display(int n, int m) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            q.add(i);// {1,2,3,4,5,6,7,8,9}
        }
        while (!q.isEmpty()) {
            int stepNum = q.poll();// got the first number
            if (stepNum >= n && stepNum <= m) {// if in range,print
                System.out.println(stepNum);
            }
            if (stepNum == 0 || stepNum > m) {
                continue;
            }
            int lastDig = stepNum % 10;// got the last digit
            int stepNumA = stepNum * 10 + (lastDig - 1);// append the last dig in two ways and find
            int stepNumB = stepNum * 10 + (lastDig + 1);
            if (lastDig == 0) {
                q.add(stepNumB);
            } else if (lastDig == 9) {
                q.add(stepNumA);
            } else {
                q.add(stepNumA);
                q.add(stepNumB);
            }
        }
    }
}
