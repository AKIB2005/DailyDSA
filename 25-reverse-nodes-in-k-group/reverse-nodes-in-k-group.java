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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        // Dummy node acts as a permanent anchor before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Pointer to track the tail node of the previously processed group
        ListNode groupPrev = dummy;
        
        while (true) {
            // Find the kth node from the current position
            ListNode kth = getKthNode(groupPrev, k);
            if (kth == null) {
                break; // Fewer than k nodes remain; leave them as-is
            }
            
            // Record the starting node of the next group
            ListNode groupNext = kth.next;
            
            // Reverse the current k-group segment in-place
            ListNode prev = groupNext; // Connect the tail of the reversed group directly to the next group
            ListNode curr = groupPrev.next;
            
            while (curr != groupNext) {
                ListNode nextTmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTmp;
            }
            
            // Update links: connect the previous group's tail to the new head of this reversed group
            ListNode nextGroupPrev = groupPrev.next; 
            groupPrev.next = kth;
            
            // Slide groupPrev forward to become the tail of the newly reversed group
            groupPrev = nextGroupPrev;
        }
        
        return dummy.next;
    }
    
    // Helper method to advance k steps and find the kth node
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 0) {
            start = start.next;
            k--;
        }
        return start;
    }
}
