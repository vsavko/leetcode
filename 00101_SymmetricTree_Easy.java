/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
  But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
  Follow up: Solve it both recursively and iteratively.*/ 
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
    public boolean isSymmetric(TreeNode root){
        if (root == null) return true;
        return isSymmetricRecursive(root.left, root.right);
    }
    
    public boolean isSymmetricRecursive(TreeNode left, TreeNode right){
        if (left == null && right == null) 
            return true;
        else if(left == null || right == null || left.val != right.val)
            return false;
        return isSymmetricRecursive(left.left, right.right) &&
                isSymmetricRecursive(left.right, right.left);
    }
    
   /* public boolean isSymmetric(TreeNode root) {
        List<List<Integer>> arr = levelOrder(root);
        for(List<Integer> lst: arr){
            int i = 0;
            int j = lst.size()-1;
            while(i < j){
                //System.out.println(lst + " " + i + " " + j);
                if(lst.get(i++) != lst.get(j--))
                    return false;
            }
        }
        return true;
    }
    
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
            if (tmpRoot == null)
                ans2.add(null);
            else
                ans2.add(tmpRoot.val);
            
            --numInQ;
            if (tmpRoot != null){
                queue.add(tmpRoot.left);
                queue.add(tmpRoot.right);
                numInQ2 += 2;
            }
            
            if (numInQ == 0){
                numInQ = numInQ2;
                numInQ2 = 0;
                ans.add(ans2);
                ans2 = new LinkedList<>();
            }
        }
        return ans;
    }*/
}
