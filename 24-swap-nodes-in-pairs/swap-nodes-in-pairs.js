/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function(head) {
    // 1. Create a dummy node to act as the visual anchor before the head
    let dummy = new ListNode(0);
    dummy.next = head;
    
    // 2. Initialize a pointer to track the node right before the pair we want to swap
    let prev = dummy;
    
    // 3. Loop as long as there is a pair left to swap
    while (prev.next !== null && prev.next.next !== null) {
        // Identify the two nodes in the current pair
        let first = prev.next;
        let second = prev.next.next;
        
        // 4. Perform the swap by adjusting pointers
        first.next = second.next; // Map first node to the rest of the list
        second.next = first;       // Put first node after the second node
        prev.next = second;       // Link the previous part of the list to the new pair head
        
        // 5. Move the prev pointer forward by two nodes for the next iteration
        prev = first;
    }
    
    // Return the actual head of the modified list
    return dummy.next;
};
