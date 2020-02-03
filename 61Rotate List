/*Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL*/

public class RotateList {
	
	  public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	  }
	  
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
