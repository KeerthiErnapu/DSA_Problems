class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty list or single node
        }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next; // Save the next node
            curr.next = prev;         // Reverse the link
            prev = curr;              // Move prev forward
            curr = next;              // Move curr forward
        }
        
        return prev; // prev is the new head after reversal
    }
}
