package localrepo.StacksQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class revKel {
    // We are given a queue q={1,2,3,4,5} and an int k=3
    // in the o/p ,reverse the firstk elements : {3,2,1,4,5}
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> res = new LinkedList<>();
        // pop k elements from q and add to the stack
        for (int i = 0; i < k; i++) {
            s.push(q.poll());
        }
        // pop all from stack and add into the new queue
        while (!s.isEmpty()) {
            res.offer(s.pop());
        }
        while (!q.isEmpty())
            res.offer(q.poll());

        return res;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5 };
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> res = new LinkedList<>();
        for (int i = 0; i < a.length; i++)
            q.offer(a[i]);
        int k = 3;
        res = modifyQueue(q, k);
        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
