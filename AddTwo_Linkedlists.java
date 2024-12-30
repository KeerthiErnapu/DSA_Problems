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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null?l2:l1;
        }
        ListNode curr1=l1,prev=l1;
        ListNode curr2=l2,prev1=l2;
        int carry=0;
        while(curr1!=null && curr2!=null){
            int sum=curr1.val+curr2.val+carry;
            carry=sum/10;
            curr1.val=sum%10;
            prev=curr1;
            curr1=curr1.next;
            prev1=curr2;
            curr2=curr2.next;
        }
        if(curr1==null){
            while(curr2!=null){
                int sum=curr2.val+carry;
                carry=sum/10;
                ListNode li=new ListNode(sum%10);
                prev.next=li;
                prev=prev.next;
                curr2=curr2.next;

            }
            if(carry>=1){
                ListNode li=new ListNode(carry);
                prev.next=li;
                prev.next.next=null;
            }
        }
        else if(curr2==null){
            while(curr1!=null){
                int sum=curr1.val+carry;
                carry=sum/10;
                curr1.val=sum%10;
                prev=curr1;
                curr1=curr1.next;
            }
            if(carry>=1){
                ListNode li=new ListNode(carry);
                prev.next=li;
                prev.next.next=null;
            }
            
        }
        return l1;
    }
}
