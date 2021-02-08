/*Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.
  Example 1:
Input: n = 3
Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
Example 2:
Input: n = 1
Output: [[1]]
  Constraints:
1 <= n <= 8*/ 
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
    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        @SuppressWarnings("unchecked")
        List<TreeNode> dp [][] = (LinkedList<TreeNode>[][]) new LinkedList<?>[n+1][n+1];
        
        //dp [][] rows = num of nodes, cols = nodes val
        
        for(int numNodes = 1; numNodes <= n; numNodes++) {
            for(int i = 1; i + numNodes <= n +1; i++ ) {
                dp[numNodes][i] = new LinkedList<TreeNode>();
                if(numNodes == 1) {
                    dp[numNodes][i] = new LinkedList<TreeNode>();
                    dp[numNodes][i].add(new TreeNode(i));
                }
                else {
                    for(int j = 0; j < numNodes; j++) {
                        
                        //add only right children
                        //System.out.println(" numNodes " + numNodes + " i " + i + " j" + j);
                        if(j == 0) {
                            //System.out.println(" test rigjt");
                            for(TreeNode t: dp[numNodes-1][i+1]) {
                                TreeNode tmpNode = new TreeNode(i+j);
                                tmpNode.right = t;
                                dp[numNodes][i].add(tmpNode);
                            }
                            
                        }
                        //add only left children
                        else if(j == numNodes-1) {
                            //System.out.println("test left");
                            for(TreeNode t: dp[numNodes-1][i]) {
                                TreeNode tmpNode = new TreeNode(i+j);
                                tmpNode.left = t;
                                dp[numNodes][i].add(tmpNode);
                            }   
                            
                        }
                        // left children first then right children
                        else {
                            //left first
                            for(TreeNode t: dp[j][i]) {
                                //then right
                                for(TreeNode t2: dp[numNodes-j-1][i+j+1]) {
                                    
                                    TreeNode tmpNode = new TreeNode(i+j);
                                    tmpNode.left = t;
                                    tmpNode.right = t2;
                                    dp[numNodes][i].add(tmpNode);
                                }
                            }
                        }
                        
                    }
                }
            }
        }
        
        //System.out.println(Arrays.deepToString(dp));
        for(int i = 0; i <= n; i++) {
            for(int j = 0 ; j <= n; j++) {
                if(dp[i][j] == null ) System.out.print("n ");
                else
                System.out.print(dp[i][j].size()+ " ");
            }
            System.out.println();
        }
        return dp[n][1];
        
    }
}
