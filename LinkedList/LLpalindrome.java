package localrepo.LinkedList;

public class LLpalindrome {
    Node head;
    
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    static Node reverse(Node head){
      Node prev=null;
      Node curr=head;
      while(curr!=null){
       Node  next=curr.next;
       curr.next=prev;
       prev=curr;
       curr=next;
      }
      return prev;
    }
    static Node findMid(Node head){
       Node hare=head;
       Node turtle=head;
       while(head.next!=null||head.next.next!=null){
        hare=hare.next.next;
        turtle=turtle.next;
       }
       return turtle;
    }
    public static boolean isPalindrome(Node head){
    //if there is only one element or no element ,then it is a palindrome
    if(head==null||head.next==null)
     return true;
    //Next comppare first half and second half of the list 
    //if the elements are equal then its a palindrome
    Node mid=findMid(head);
    Node secondHalf=reverse(mid.next);
    Node firstHalf=head;
    while(secondHalf!=null){
        if(firstHalf!=null){
            if(firstHalf.val!=secondHalf.val)
              return false;
        }
        firstHalf=firstHalf.next;
        secondHalf=secondHalf.next;
    }
    return true;
    }
    public static void main(String[] args) {
        LLimplementation ob=new LLimplementation();
        
    }
}
