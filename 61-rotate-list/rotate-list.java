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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // 1. Compute length and find the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // 2. Minimize rotations
        k %= length;
        if (k == 0) {
            return head;
        }
        
        // 3. Connect tail to head to form a circle
        tail.next = head;
        
        // 4. Find the new tail node
        int stepsToNewTail = length - k;
        for (int i = 0; i < stepsToNewTail; i++) {
            tail = tail.next;
        }
        
        // 5. Set the new head and break the circle
        ListNode newHead = tail.next;
        tail.next = null;
        
        return newHead;
    }
}
