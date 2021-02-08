/*Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.
The encoded string should be as compact as possible.
  Example 1:
Input: root = [2,1,3]
Output: [2,1,3]
Example 2:
Input: root = []
Output: []
  Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The input tree is guaranteed to be a binary search tree.*/ 
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

    
    // Encodes a tree to a single string.
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
        //System.out.println(Arrays.toString(items) + items.length);
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
        //System.out.println(Arrays.toString(items));
        //System.out.println(stack.firstElement().val);
        return ansNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
