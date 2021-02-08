/*Given the head of a linked list, rotate the list to the right by k places.
  Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
  Constraints:
The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109*/ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
public ListNode rotateRight(ListNode head, int k) {
          if (head == null) return null;
          
          int count = 1;
          ListNode head2 = head, firstHead = head;
          
            while(head2.next != null) {
                ++count;
                head2 = head2.next; 
            }
          
          int shift = k % count;
          
          if ( shift > 0 ) {
              head2.next = head;
              head2 = head;
              for(int i = 0; i < (count - shift - 1); i++) {
                  head2 = head2.next;
              }
              firstHead = head2.next;
              head2.next = null;
          }
          
          return firstHead;
            
      }
}
