/*Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
  Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:
Input: root = [1,2], p = 1, q = 2
Output: 1
  Constraints:
The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.*/ 
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
    int max_path = -1;
    TreeNode min_root = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursive(root, p, q, 0);
        return min_root;
    }
    
    private boolean recursive(TreeNode root, TreeNode p, TreeNode q, int depth){
        if (root == null || p == null || q == null) return false;
        boolean ret = false;
        if (root.val == p.val || root.val == q.val) ret = true;
        boolean left = recursive(root.left, p ,q, depth +1);
        boolean right = recursive(root.right, p ,q, depth +1);
        if ((ret == true && (left == true || right == true))||
            (left == true && right == true)){
            if(depth > max_path){
                max_path = depth;
                min_root = root;
            }
                
        }
        if (left == true || right == true) ret = true;
        return ret;
    }
    
}
