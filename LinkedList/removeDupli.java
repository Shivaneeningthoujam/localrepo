package localrepo.LinkedList;

import java.util.HashSet;

/**
 * In this we have to remove duplicate elemments from a linked List
 */
public class removeDupli {
    Node head;

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static void remove(Node head) {
        // Case when there is no element or only one element in the list
        if (head == null || head.next == null)
            return;
        // IN THIS method ,we use hashset to store the vals of the nods already seen
        HashSet<Integer> seen = new HashSet<>();
        Node curr = head;
        Node  prev=null;
        while(curr!=null){
            if(seen.contains(curr.val))
             prev.next=prev.next.next;//Skipping the current val i.e completely removing it
             else{
                //IF the val is not in seen,add it to the hashset
                seen.add(curr.val);
                prev=curr;
             }
             curr=curr.next;
        }
    }

}