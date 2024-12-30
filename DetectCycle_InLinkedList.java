/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ArrayList<ListNode> arr=new ArrayList<>();
        ListNode curr=head;
        while(curr.next!=null){
            if(arr.contains(curr.next)){
                return true;
            }
            else{
                arr.add(curr.next);
            }
            curr=curr.next;
        }
        return false;
    }
}
