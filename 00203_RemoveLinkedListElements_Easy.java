/*Remove all elements from a linked list of integers that have value val.
Example:
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5*/ 
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmpHead = head;
        ListNode previous = null;
        while(tmpHead != null){
            if(tmpHead.val == val){
               if (previous != null) previous.next = tmpHead.next;
            }
            else{
                previous = tmpHead;
            }
            if (previous == null) head = tmpHead.next;
            tmpHead = tmpHead.next;
        }
        return head;
    }
}
