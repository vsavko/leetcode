/*Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
  Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:
Input: root = []
Output: 0
Example 3:
Input: root = [1]
Output: 1
  Constraints:
The number of nodes in the tree is in the range [0, 5 * 104].
0 <= Node.val <= 5 * 104
The tree is guaranteed to be complete.
  Follow up: Traversing the tree to count the number of nodes in the tree is an easy solution but with O(n) complexity. Could you find a faster algorithm?*/ 
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
    int N = 0;
    
    public int countNodes(TreeNode root) {
        countNodesREcursive(root);
        return N;
    }
    
    public void countNodesREcursive(TreeNode root){
        if(root != null){
            ++N;
            countNodesREcursive(root.left);
            countNodesREcursive(root.right);
        }
    }
}
