/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int x = 0, y = 0;
        int digit = 1;
        int remainder = 0;
        int nextDigit = 0;
        int v1, v2;
        
        remainder = (l1.val + l2.val) %10;
        nextDigit = (l1.val + l2.val) / 10;
            
        ListNode l3 = new ListNode(remainder);
        ListNode l4 = l3;
        l1 = l1.next;
        l2 = l2.next;
        
        while (l1 != null || l2 != null || nextDigit != 0){
            if (l1 == null)
              v1 = 0;
            else
             v1 = l1.val;
            
            if (l2 == null)
              v2 = 0;
            else
             v2 = l2.val;
 

            remainder = (v1 + v2 + nextDigit) %10 ;
            nextDigit = (v1 + v2 + nextDigit) / 10;

            l3.next = new ListNode(remainder);
            l3 = l3.next;
            
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return l4;
    }
}
