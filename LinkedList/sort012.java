package localrepo.LinkedList;

public class sort012 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void sortList() {
        // initialising the counts of 0,1,2 as 0
        int count[] = { 0, 0, 0 };
        Node curr = head;
        /*
         * count[0] stores 0s
         * count[1]-->1s
         * count[2]-->2s
         */
        while (curr != null) {
            count[curr.data]++;
            curr = curr.next;
        }
        int i = 0;
        curr = head;
        while (curr != null) {
            if (count[i] == 0)
                i++;
            else {
                curr.data = i;
                --count[i];
                curr = curr.next;
            }
        }
        // int count[] = { 0, 0, 0 };
        // Node curr = head;
        // while (curr != null) {
        // count[curr.data]++;// count the number of 0s,1s,2s
        // curr = curr.next;
        // }
        // int i = 0;
        // curr = head;// reset
        // while (curr != null) {
        // if (count[i] == 0)
        // i++;
        // else {
        // curr.data = i;
        // --count[i];
        // curr = curr.next;
        // }
        // }

    }
}
