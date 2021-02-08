'''Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
You may not modify the values in the list's nodes, only nodes itself may be changed.
Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.''' 
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: ListNode) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if head == None or head.next == None:
            return
        head2 = head
        nodeLocation = []
        while head2 != None:
            nodeLocation.append(head2)
            head2 = head2.next
        last = len(nodeLocation) - 1
        rng  = 0
        if len(nodeLocation) % 2 == 0:
            rng = len(nodeLocation)//2
        else:
            rng = len(nodeLocation) // 2 + 1
        end = len(nodeLocation) // 2
        for h in range(0,rng):
            nodeLocation[h].next = nodeLocation[len(nodeLocation) - 1 - h]
            nodeLocation[len(nodeLocation) - 1 - h].next = nodeLocation[h+1]
        nodeLocation[end].next = None
