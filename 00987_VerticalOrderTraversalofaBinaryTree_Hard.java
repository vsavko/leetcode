/*Given the root of a binary tree, calculate the vertical order traversal of the binary tree.
For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).
The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.
Return the vertical order traversal of the binary tree.
  Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation:
Column -1: Only node 9 is in this column.
Column 0: Nodes 3 and 15 are in this column in that order from top to bottom.
Column 1: Only node 20 is in this column.
Column 2: Only node 7 is in this column.
Example 2:
Input: root = [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
Column -2: Only node 4 is in this column.
Column -1: Only node 2 is in this column.
Column 0: Nodes 1, 5, and 6 are in this column.
          1 is at the top, so it comes first.
          5 and 6 are at the same position (2, 0), so we order them by their value, 5 before 6.
Column 1: Only node 3 is in this column.
Column 2: Only node 7 is in this column.
Example 3:
Input: root = [1,2,3,4,6,5,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation:
This case is the exact same as example 2, but with nodes 5 and 6 swapped.
Note that the solution remains the same since 5 and 6 are in the same location and should be ordered by their values.
  Constraints:
The number of nodes in the tree is in the range [1, 1000].
0 <= Node.val <= 1000*/ 
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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int treeLeftWidth = getTreeWidthLeft(root, 0, 0);
        int treeRightWidth = getTreeWidthRight(root, 0, 0);
        //System.out.println((treeLeftWidth ));
        //System.out.println((treeRightWidth ));
        //root position is treeLeftWidth
        
        List<List<TreeNodePosition>> ans = new ArrayList<>(treeLeftWidth + treeRightWidth +1);
        for(int i = 0; i < (treeLeftWidth + treeRightWidth +1); i++) {
            ans.add(new ArrayList<TreeNodePosition>());
        }
        //System.out.println(ans.size());
        
        Queue<TreeNodePosition> queue = new LinkedList<>();
        queue.add(new TreeNodePosition(root,treeLeftWidth,0));
        
        while(!queue.isEmpty()) {
            TreeNodePosition tmp = queue.poll();
            //check collision if previous node is in the same spot
            if(tmp.root == null) continue;  
            ans.get(tmp.x).add(tmp);
            queue.add(new TreeNodePosition(tmp.root.left,tmp.x-1,tmp.y+1));
            queue.add(new TreeNodePosition(tmp.root.right,tmp.x+1,tmp.y+1));
        }
        
        List<List<Integer>> ans2 = new LinkedList<>();
        for(List<TreeNodePosition> key : ans) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            ans2.add(tmp);
            
            
            
            Collections.sort( key, new Comparator<TreeNodePosition>() {
                   public int compare(TreeNodePosition x1, TreeNodePosition x2) {
                     int result = Integer.compare(x1.y, x2.y);
                     if ( result == 0 ) {
                       // both X are equal -> compare Y too
                       result = Integer.compare(x1.x, x2.x);
                     } 
                     if ( result == 0 ) {
                       // both X are equal -> compare Y too
                       result = Integer.compare(x1.root.val, x2.root.val);
                     } 
                     return result;
                  }
                });
            
            for(int i = 0; i < key.size(); i++) {
                tmp.add(key.get(i).root.val);
            }
        }
        
        
        return ans2;
    }
    
    private int getTreeWidthLeft(TreeNode root, int currentSize, int maxSize){
        if(root == null) return maxSize;
        if(currentSize > maxSize) maxSize = currentSize;
        return Math.max(getTreeWidthLeft(root.left, currentSize +1, maxSize), getTreeWidthLeft
            (root.right, currentSize -1, maxSize));
    }
    
    private int getTreeWidthRight(TreeNode root, int currentSize, int maxSize){
        if(root == null) return maxSize;
        if(currentSize > maxSize) maxSize = currentSize;
        return Math.max(getTreeWidthRight(root.right, currentSize +1, maxSize), 
            getTreeWidthRight(root.left, currentSize -1, maxSize));
    }
    
    private class TreeNodePosition{
        TreeNode root;
        int x, y;
        
        public TreeNodePosition(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
        
    }
    
}
