/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
  Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
  Constraints:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.*/ 
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
    private class TreeParent{
        TreeNode node;
        TreeNode parent;
        public TreeParent(TreeNode node, TreeNode parent) {
            super();
            this.node = node;
            this.parent = parent;
        }
        
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        //bfs
        Stack<TreeParent> stack1 = new Stack<>();
        Stack<TreeParent> stack2 = new Stack<>();
        boolean xSwitch = false, ySwitch = false;
        
        stack1.add(new TreeParent(root,root));
        TreeNode parent1 = null;
        TreeNode parent2 = null;
        while(!stack1.isEmpty()) {
 
            TreeParent tmpNode = stack1.pop();
            //System.out.println(tmpNode.node.val);
            if(tmpNode.node.left != null)
                stack2.add(new TreeParent(tmpNode.node.left,tmpNode.node));
            if(tmpNode.node.right != null)
                stack2.add(new TreeParent(tmpNode.node.right,tmpNode.node));
            if (tmpNode.node.val == x) {
                xSwitch = true;
                parent1 = tmpNode.parent;
                //System.out.println("a " + tmpNode.parent.val);
            }
            if (tmpNode.node.val == y) { 
                ySwitch = true;
                parent2 = tmpNode.parent;
                //System.out.println("b " + tmpNode.parent.val);
            }
            if (xSwitch == true && ySwitch == true && parent1 != parent2) {  
                //System.out.println(parent1.val);
                //System.out.println(parent2.val);
                return true;
            
            }
            
            if(stack1.isEmpty()) {
                if(xSwitch == true || ySwitch == true) return false;
                stack1 = stack2;
                stack2 = new Stack<>();
            }
        }
        return false;
    }
    
}
