/*Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
  Example 1:
Input: root = [2,1,3]
Output: true
Example 2:
Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
  Constraints:
The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1*/ 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (isValidBST2(root.left, root.val, null) && 
            isValidBST2(root.right, null, root.val) )
            return true;
        return false;
    }
    
    private boolean isValidBST2(TreeNode root, Integer max, Integer min) {
        if(root == null) return true;
        if((max != null && root.val >= max) || (min != null && root.val <= min))
            return false;
        if (isValidBST2(root.left, root.val, min) && 
           isValidBST2(root.right, max, root.val))
            return true;
        return false;
    }
}
