package localrepo.LinkedList;

//we are given a LL and we have to reorder it in such a way
//i/p: 1->2->3->4
//o/p:1->4->2->3
public class reorderLL {
   Node head;

   class Node {
      int val;
      Node next;

      Node(int val) {
         this.val = val;
         this.next = null;
      }
   }

   static void reorder(Node head) {
      // 1.find mid
      Node p1 = head;
      Node p2 = head;
      while (p2.next != null || p2.next.next != null) {
         p1 = p1.next;
         p2 = p2.next.next;
      }
      // Reverse the half after the mid
      Node preMid = p1;
      Node preCurr = p1.next;
      while (preCurr.next != null) {
         Node curr = preCurr.next;
         preCurr.next = curr.next;
         curr.next = preMid.next;
         preMid.next = curr;
      }
      // Reorder 1 by 1
      p1 = head;
      p2 = preMid.next;
      while (p1 != preMid) {
         preMid.next = p2.next;
         p2.next = p1.next;
         p1.next = p2;
         p1 = p2.next;
         p2 = preMid.next;
      }
   }
}
