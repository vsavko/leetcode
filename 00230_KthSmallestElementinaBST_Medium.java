/*Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
  Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1
Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
  Constraints:
The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
  Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?*/ 
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
    int ans;
    
    public int kthSmallest(TreeNode root, int k) {
        recursiveFind(0, root, k);
        return ans;
    }
    
    private int recursiveFind(int current, TreeNode root, int k) {
        if (root.left != null)
            current = recursiveFind(current, root.left, k);
        
        ++current;
        if (current == k) ans = root.val;
        
        if (current < k && root.right != null)
            current = recursiveFind(current, root.right, k);
        
        return current;
    }
}
