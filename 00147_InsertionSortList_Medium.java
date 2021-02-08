/*Sort a linked list using insertion sort.

A graphical example of insertion sort. The partial sorted list (black) initially contains only the first element in the list.
With each iteration one element (red) is removed from the input data and inserted in-place into the sorted list
  Algorithm of Insertion Sort:
Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
It repeats until no input elements remain.

Example 1:
Input: 4->2->1->3
Output: 1->2->3->4
Example 2:
Input: -1->5->3->4->0
Output: -1->0->3->4->5*/ 
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
    public ListNode insertionSortList(ListNode head) {
        int listLen = 0;
        ListNode tmpHead = head;
        while(tmpHead != null){
            tmpHead = tmpHead.next;
            ++listLen;
        }
        //System.out.println(listLen);
       
        for(int i = 1; i < listLen; i++){
            tmpHead = head;
            ListNode prev = null;
            for(int j = 0; j < i; j++){
                prev = tmpHead;
                tmpHead = tmpHead.next;
            }
            prev.next = tmpHead.next;
           
            if(tmpHead.val < head.val){
                tmpHead.next = head;
                head = tmpHead;
            }
            else{
                ListNode tmpHead2 = head;
                for(int j = 0; j < i; j++){
                    prev = tmpHead2;
                    tmpHead2 = tmpHead2.next;
                    if(tmpHead2 == null || tmpHead.val < tmpHead2.val)
                        break;
                }
                 //System.out.println(prev.val + " " + tmpHead.val + " prev.next " + prev.next
                     .val);
                tmpHead.next = prev.next;
                prev.next = tmpHead;
            }
        } 
        return head;
    }
}
