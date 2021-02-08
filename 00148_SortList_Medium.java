/*Given the head of a linked list, return the list after sorting it in ascending order.
Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
  Example 1:
Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:
Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:
Input: head = []
Output: []
  Constraints:
The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105*/ 
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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        //count elements
        int count = 0;
        ListNode headTmp = head;
        while(headTmp != null) {
            count++;
            headTmp = headTmp.next;
        }
        //mergesort
        return mergeSort(head, count, head);
    }
    
    private ListNode mergeSort(ListNode head, int count, ListNode original) {
        //System.out.println("1 head1.val " +head.val + " count " + count);
        if (count == 1) return head;
        ListNode head2 = head;
        for (int step = 0; step < count/2; step++) {
            head2 = head2.next; 
        }
        ListNode head1 = mergeSort(head, count /2, original);
        head2 = mergeSort(head2, count - count /2, original);
        return swap(head1,head2, count/2, count - count /2);
    }
    
    private ListNode swap(ListNode head1, ListNode head2, int count1, int count2) { 
        int i = 0, j = 0;
        ListNode ans = new ListNode();
        ListNode tmp = ans;
        while(i < count1 || j < count2) {
            //System.out.println(head1.val + " " + head2.val);
            if(j == count2) {
                tmp.next = head1;
                head1 = head1.next;
                ++i;
            }
            else if(i == count1) {
                tmp.next = head2;
                head2 = head2.next;
                ++j;
            }
            else {
                if (head1.val <= head2.val) {
                    tmp.next = head1;
                    head1 = head1.next;
                    ++i;
                }
                else {
                    tmp.next = head2;
                    head2 = head2.next;
                    ++j;
                }
            }
            tmp = tmp.next;
        }
        tmp.next = null;
        //System.out.println(ans.next.val);
        return ans.next;
    }
}
