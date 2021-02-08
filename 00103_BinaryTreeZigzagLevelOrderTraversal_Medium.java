/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
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
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new LinkedList<List<Integer>>();
        boolean left = true;
        Stack<TreeNode> stackLeft = new Stack<>();
        Stack<TreeNode> stackRight = new Stack<>();
        stackLeft.push(root);
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        
        while(!stackLeft.isEmpty() || !stackRight.isEmpty()){
            ans.add(new LinkedList<Integer>());
            List<Integer> ansList = ans.get(ans.size() -1);
            
            if(left){
                while(!stackLeft.isEmpty()){
                    TreeNode tmp = stackLeft.pop();
                    ansList.add(tmp.val);
                    if(tmp.left != null) stackRight.add(tmp.left);
                    if(tmp.right != null) stackRight.add(tmp.right);
                }
                left = false;
            }
            else{
                while(!stackRight.isEmpty()){
                    TreeNode tmp = stackRight.pop();
                    ansList.add(tmp.val);
                    if(tmp.right != null) stackLeft.add(tmp.right);
                    if(tmp.left != null) stackLeft.add(tmp.left);
                }
                left = true;
            }
        }
        return ans;
    }
}
