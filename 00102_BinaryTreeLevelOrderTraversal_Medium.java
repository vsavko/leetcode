/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/ 
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;
        queue.add(root);
        int numInQ = 1;
        int numInQ2 = 0;
        List<Integer> ans2 = new LinkedList<>();
        
        while(!queue.isEmpty()){
            
            TreeNode tmpRoot = queue.poll();
            ans2.add(tmpRoot.val);
            --numInQ;
            
            if (tmpRoot.left != null){
                ++numInQ2;
                queue.add(tmpRoot.left);
            }
            if (tmpRoot.right != null){
                ++numInQ2;
                queue.add(tmpRoot.right);
            }
            if (numInQ == 0){
                numInQ = numInQ2;
                numInQ2 = 0;
                ans.add(ans2);
                ans2 = new LinkedList<>();
            }
        }
        return ans;
    }
}
