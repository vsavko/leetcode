/*Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
It is guaranteed that the answer will in the range of 32-bit signed integer.
Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
  Constraints:
The given binary tree will have between 1 and 3000 nodes.*/ 
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
    
    public int widthOfBinaryTree(TreeNode root) {
        ArrayList<Integer> leftPos = new ArrayList<>();
        ArrayList<Integer> rigthPos = new ArrayList<>();
        dfs(root, leftPos, rigthPos, 0, 1);
        int max = 0;
        
        for(int i =0; i < rigthPos.size(); i++){
            if((rigthPos.get(i) - leftPos.get(i)) > max)
                max = rigthPos.get(i) - leftPos.get(i);
        }
        //System.out.println(rigthPos);
        return max +1;
    }
    
    private void dfs(TreeNode root, ArrayList<Integer> leftPos, ArrayList<Integer> rigthPos, 
        int level, int position) {
        if(root == null) return;
        if(rigthPos.size() < level+1){
          leftPos.add(level, position);
          rigthPos.add(level, position);
        }
        else
          rigthPos.set(level, position);  
        dfs(root.left, leftPos, rigthPos, level+1, ((position -1) * 2) + 1);
        dfs(root.right, leftPos, rigthPos, level+1, ((position -1) * 2) + 2);
    }
}
