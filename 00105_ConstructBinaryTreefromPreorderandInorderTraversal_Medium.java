/*Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
For example, given
preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:
    3
   / \
  9  20
    /  \
   15   7*/ 
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
    int preorderPos;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;
        preorderPos = 0;
        TreeNode root = new TreeNode();
        recursive(root, preorder, inorder);
        return root;
    }
    
    private void recursive(TreeNode root, int [] preorder, int [] inorder){
        
        root.val = preorder[preorderPos++];
        if (inorder.length == 1) return;
        int mid = IntStream.range(0, inorder.length).filter(i -> inorder[i] == root.val
            ).findFirst().orElse(-1);
        //System.out.println(Arrays.toString(inorder) );
        //System.out.println("mid " +mid);
        if(mid > 0 && mid < inorder.length -1) {
            //System.out.println("t0");
            int[] left = Arrays.copyOfRange(inorder, 0, mid);
            int[] right = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
            root.left = new TreeNode();
            root.right = new TreeNode();
            recursive(root.left, preorder, left);
            recursive(root.right, preorder, right);
        }
        else if(mid == 0) {
            //System.out.println("t1");
            root.right = new TreeNode();
            recursive(root.right, preorder, Arrays.copyOfRange(inorder, 1, inorder.length));
        }
        else {
            //System.out.println("t2");
            root.left = new TreeNode();
            recursive(root.left, preorder, Arrays.copyOfRange(inorder, 0, inorder.length-1));
        }
    }
}
