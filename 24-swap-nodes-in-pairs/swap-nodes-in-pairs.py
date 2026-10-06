# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def swapPairs(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # Create a dummy node to act as the foundational anchor before the head
        dummy = ListNode(0)
        dummy.next = head
        prev = dummy
        
        # Traverse the list as long as there is a pair left to swap
        while prev.next and prev.next.next:
            # Identify the two nodes to be swapped
            first = prev.next
            second = first.next
            
            # Rearrange the pointers
            first.next = second.next
            second.next = first
            prev.next = second
            
            # Jump the prev pointer forward by two positions (now at 'first')
            prev = first
            
        return dummy.next
