/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	
    // Encodes a tree to a single string. Using preorder traversal
    public String serialize(TreeNode root) {
    	if (root == null)
    		return "";
        StringBuilder codedTree = new StringBuilder();
        codedTree.append(root.val);
        codedTree.append(',');
        if (root.left != null)
        	codedTree.append(serialize(root.left));
        if (root.right != null)		
        	codedTree.append(serialize(root.right));
        return codedTree.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if (data == "") return null;
    	String[] items = data.split(",");
    	if (items.length < 1) return null;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode ansNode = new TreeNode(Integer.parseInt(items[0]));
    	TreeNode currentNode = ansNode;
    	
    	for (int i = 1; i < items.length; i++) {
    		String item = items[i];
    		int intItem = Integer.parseInt(item);
    		TreeNode node = new TreeNode(intItem);
 
			if (currentNode.val > intItem) {
				currentNode.left = node;
				stack.push(currentNode);
			}
			else {
				while(!stack.isEmpty() && stack.peek().val < node.val)
					currentNode = stack.pop();
				currentNode.right = node;
			}   
			currentNode = node;
    	}
    	return ansNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
