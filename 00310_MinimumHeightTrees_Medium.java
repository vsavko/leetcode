/*A tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.
Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges where edges[i] = [ai, bi] indicates that there is an undirected edge between the two nodes ai and bi in the tree, you can choose any node of the tree as the root. When you select a node x as the root, the result tree has height h. Among all possible rooted trees, those with minimum height (i.e. min(h))  are called minimum height trees (MHTs).
Return a list of all MHTs' root labels. You can return the answer in any order.
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
  Example 1:
Input: n = 4, edges = [[1,0],[1,2],[1,3]]
Output: [1]
Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
Example 2:
Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
Output: [3,4]
Example 3:
Input: n = 1, edges = []
Output: [0]
Example 4:
Input: n = 2, edges = [[0,1]]
Output: [0,1]
  Constraints:
1 <= n <= 2 * 104
edges.length == n - 1
0 <= ai, bi < n
ai != bi
All the pairs (ai, bi) are distinct.
The given input is guaranteed to be a tree and there will be no repeated edges.*/ 
class Solution {
     public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ansList = new ArrayList<>();
        
        if (n == 1) {
            ansList.add(0);
            return ansList;
        }
        
        HashMap<Integer, LinkedList<Integer>> tree = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            tree.put(i, new LinkedList<Integer>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            tree.get(edges[i][0]).add(edges[i][1]);
            tree.get(edges[i][1]).add(edges[i][0]);
        }
        
        
        
        NodeLength maxLen1 = dfs(0, tree, 0, 0);
        NodeLength maxLen2 = dfs(maxLen1.node, tree, maxLen1.node, 0);
        
        //System.out.println("maxLen1.node " + maxLen1.node + " " + maxLen2.node);
        
        ArrayList<Integer> path = dfs2(maxLen1.node, maxLen2.node, maxLen1.node, tree, new 
            ArrayList<Integer>());
        
        //System.out.println("p" + path);
        
        if (path.size() % 2 == 1) 
        {
            ansList.add(path.get(path.size()/2));
        }
        else {
            ansList.add(path.get(path.size()/2 - 1));
            ansList.add(path.get(path.size()/2));
        }

        return ansList;
    }
    
    class NodeLength{
        int len;
        int node;

        public NodeLength(int len, int node) {
            this.len = len;
            this.node = node;
        }
        
    }
    
    private NodeLength dfs(int node, HashMap<Integer, LinkedList<Integer>> tree, int visited, 
        int pathLen) {
        if(tree.get(node).size() == 1 && tree.get(node).get(0) == visited) { //is a leaf
            //System.out.println("found" + node+ " " +pathLen);
            return new NodeLength(pathLen, node);
        }
        int maxPath = 0;
        NodeLength ans = null;
        
        //System.out.println("node " + node + " pathLen " + pathLen + " visited " + visited);
        for(Integer curNode: tree.get(node)) {
            if(curNode != visited) {
                NodeLength tmpPath = dfs(curNode, tree, node, pathLen+1);
                if(tmpPath.len > maxPath) {
                    maxPath = tmpPath.len;
                    ans = tmpPath;
                    //System.out.println("maxPath" + maxPath + " " + tmpPath.node);
                }
            }
        }

        return ans;
    }
    
    private ArrayList<Integer> dfs2(int start, int end, int visited, HashMap<Integer, 
        LinkedList<Integer>> tree, ArrayList<Integer> path){
        if(start == end) {
            path.add(start);
            return path;
        }
        if(tree.get(start).size()==1 && tree.get(start).get(0) == visited)
            return null;
        ArrayList<Integer> ans = null;
        path.add(start);
        for(Integer curNode: tree.get(start)) {
            if(curNode != visited) {
                ArrayList<Integer> ans2  = dfs2(curNode, end, start, tree, path);
                if(ans2 != null) return ans2;
            }
        }
        path.remove(path.size()-1);
        return ans;
        
    }
      
}
