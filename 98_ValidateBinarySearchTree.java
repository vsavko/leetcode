/*Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:

    2
   / \
  1   3

Input: [2,1,3]
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.*/

class ValidateBinarySearchTree {
	
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
    	if (root.left != null) {
	    	if (recusriveBSTCheck(root.val, null, root.left) == false)
	    		return false;
    	}
    	if (root.right != null) {
    		return recusriveBSTCheck(null, root.val, root.right);
    	}
    	return true;
    }
    
    public boolean recusriveBSTCheck (Integer low, Integer high, TreeNode currentNode) {
    	if (currentNode == null) return true;
    	//if (currentNode.val >= low || currentNode.val <= high) {
    	if ((low != null && Integer.compare(currentNode.val , low) >= 0 ) || 
    			(high != null && Integer.compare(currentNode.val , high) <= 0 )) {
    		return false;
    	}
    	
    	if (recusriveBSTCheck(currentNode.val, high, currentNode.left) == false)
    		return false;
    	return recusriveBSTCheck(low, currentNode.val, currentNode.right);
    }
    
    public static void main(String[] args) {
    	ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
    	
    	ValidateBinarySearchTree.TreeNode nestedObject =  bst.new TreeNode(-2147483648);
    	nestedObject.right = bst.new TreeNode(2147483647);
    	
    	System.out.println(bst.isValidBST(nestedObject));
    	
    			
	}
}
