/*Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
  Example 1:
Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:
Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:
Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:
Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:
Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]
  Constraints:
n == graph.length
2 <= n <= 15
0 <= graph[i][j] < n
graph[i][j] != i (i.e., there will be no self-loops).
The input graph is guaranteed to be a DAG.*/ 
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        HashMap<Integer, LinkedList<Integer>> hm = new HashMap<>();
        
        //create graphs hashmap
        for(int i = 0; i < graph.length; i++){
            hm.put(i,new LinkedList<Integer>());
            for(int j = 0; j < graph[i].length; j++){
                hm.get(i).add(graph[i][j]);
            }
        }
        
        //dfs
        HashSet<Integer> visited = new HashSet<>();
        List<List<Integer>> ans = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(0);
        visited.add(0);
        dfs(visited,ans,hm,0,graph.length -1, path);
        return ans;
    }
    
    private void dfs(HashSet<Integer> visited, List<List<Integer>> ans, HashMap<Integer, 
                     LinkedList<Integer>> hm, int node, int target, ArrayList path){
        if (node == target) {
            ans.add(new LinkedList<Integer>(path));
            return;
        }
        LinkedList<Integer> tmp = hm.get(node);
        for(Integer key: tmp){
            if (visited.contains(key)) continue;
            visited.add(key);
            path.add(key);
            dfs(visited, ans, hm, key, target, path);
            path.remove(path.size()-1);
            visited.remove(key);
        }
    }
}
