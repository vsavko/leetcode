/*Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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
    int totalLevels = 0;
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) return ans;
        ans.add(new LinkedList<Integer>());
        dfs(root,0,ans);
        return ans;
    }
    
    private void dfs(TreeNode root, int level, LinkedList<List<Integer>> ans ){
        if(root == null) return;
        //System.out.println("test");
        if(level> totalLevels) { 
            ++totalLevels;
            ans.add(0, new LinkedList<Integer>());
        }
        ans.get(totalLevels -level).add(root.val);
        dfs(root.left, level +1, ans);
        dfs(root.right, level +1, ans);
        return;
    }
}
