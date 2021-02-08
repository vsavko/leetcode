/*You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
Follow up: A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
  Example 1:
Input: root = [1,3,null,null,2]
Output: [3,1,null,null,2]
Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
Example 2:
Input: root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
  Constraints:
The number of nodes in the tree is in the range [2, 1000].
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
        TreeNode root; 
        TreeNode swap1 = null;
        TreeNode swap2 = null;
        TreeNode prevNode = null;
        
        public void recoverTree(TreeNode root) {
            MorrisTraversal(root);
            int tmp = swap1.val;
            swap1.val = swap2.val;
            swap2.val = tmp;
        }

        /* Function to traverse a binary tree without recursion and 
        without stack */
        private void MorrisTraversal(TreeNode root) 
        { 
            TreeNode current, pre; 

            if (root == null) 
                return; 

            current = root; 
            while (current != null) { 

                if (current.left == null) { 
                    //System.out.println(current.val + " "); 
                    //if(prevNode != null) System.out.println("P" + prevNode.val);
                    if(prevNode != null && swap1 == null && prevNode.val > current.val) swap1 
                        = prevNode;
                    if(swap1 != null && prevNode.val > current.val) swap2 = current;
                    prevNode = current;
                    current = current.right; 
                } 
                else { 
                    /* Find the inorder predecessor of current */
                    pre = current.left; 
                    while (pre.right != null && pre.right != current) 
                        pre = pre.right; 

                    /* Make current as right child of its inorder predecessor */
                    if (pre.right == null) { 
                        pre.right = current; 
                        current = current.left; 
                    } 

                    /* Revert the changes made in the 'if' part to restore the 
                        original tree i.e., fix the right child of predecessor*/
                    else { 
                        pre.right = null; 
                        if(prevNode != null && swap1 == null && prevNode.val > current.val) 
                            swap1 = prevNode;
                        if(swap1 != null && prevNode.val > current.val) swap2 = current;
                        prevNode = current;
                        current = current.right; 
                    } /* End of if condition pre->right == NULL */

                } /* End of if condition current->left == NULL*/

            } /* End of while */
        } 

    
}
