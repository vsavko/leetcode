/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5*/

public class ConvertSortedListToBST {
	
	 private ListNode currentHead;
	
	 public TreeNode sortedListToBST(ListNode head) {
	        //count nodes
		int count  = 0;
		ListNode tmpHead = head;
		while (tmpHead != null) {
			count++;
			tmpHead = tmpHead.next;
		}
		//reccur
		currentHead = head;
		return buildBST(count);
	 }
	 
	 public TreeNode buildBST(int count) {
		 if (count == 0) return null;
		 int medium = (count + 1 ) / 2;
		 TreeNode left = buildBST(medium-1);
		 TreeNode tn2 = new TreeNode(currentHead.val);
		 currentHead = currentHead.next;
		 tn2.left = left;
		 tn2.right = buildBST(count-medium);
		 return tn2; 
	 }
}
