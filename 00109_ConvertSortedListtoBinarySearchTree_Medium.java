/*Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
  Example 1:
Input: head = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
Example 2:
Input: head = []
Output: []
Example 3:
Input: head = [0]
Output: [0]
Example 4:
Input: head = [1,3]
Output: [3,1]
  Constraints:
The number of nodes in head is in the range [0, 2 * 104].
-10^5 <= Node.val <= 10^5*/ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
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
