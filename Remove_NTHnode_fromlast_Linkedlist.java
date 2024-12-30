/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       if(head.next==null && n==1){
           head=null;
           return head;
       }
       ListNode prev=head,curr=prev.next,c=head;
       int i=1,l=1;
       while(c.next!=null){
           l=l+1;
           c=c.next;
       }
       int t=l-n;
       if(t==0){
           head=prev.next;
           prev.next=null;
           return head;
       }
       while(prev.next!=null && i<t){
           prev=prev.next;
           i=i+1;
       }
       prev.next=prev.next.next;
       return head;
       
    }
}
