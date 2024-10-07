package localrepo.OA;

public class reorderLL {
    class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head;
    static void reord(Node head){
      //base case
      if(head==null||head.next==null) return;
      //find mid
      Node p1=head,p2=head;
      while (p2.next!=null&&p2.next.next!=null) {
        p1=p1.next;
        p2=p2.next.next;
      }//p1=mid
      //Reverse the second half of the list
      Node preMid=p1,preCurr=p1.next;
      while(preCurr.next!=null){
       Node curr=preCurr.next;
       preCurr.next=curr.next;
       curr.next=preMid.next;
       preMid.next=curr;
      }
      //Reorder one by one
      p1=head;p2=preMid.next;
      while(p1!=preMid){
        preMid.next=p2.next;
        p2.next=p1.next;
        p1.next=p2;
        p1=p2.next;
        p2=preMid.next;
      }
    }
}
