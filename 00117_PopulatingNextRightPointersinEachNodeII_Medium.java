/*Given a binary tree
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
  Follow up:
You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
  Example 1:
Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
  Constraints:
The number of nodes in the given tree is less than 6000.
-100 <= node.val <= 100*/ 
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null ) return root;
        Node originalRoot = root;
        Node rootNext = null;
        while (root != null){
            if (rootNext != null){
                if (root.left != null){
                    rootNext.next = root.left;
                    rootNext = null;
                }
                else if (root.right != null){
                    rootNext.next = root.right;
                    rootNext = null;
                }
            }
            if (root.left != null && root.right != null){
                root.left.next = root.right;
            }
            
            if (root.left != null && root.right == null)
                rootNext = root.left;
            
            if ( root.right != null)
                rootNext = root.right;
            root = root.next;
        } 
        connect(originalRoot.left);
        connect(originalRoot.right);
        return originalRoot;
    }
}
