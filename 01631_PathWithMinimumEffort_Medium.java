/*You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
  Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].
Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
  Constraints:
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106*/ 
class Solution {
    int [][] dp;
    public int minimumEffortPath(int[][] heights) {
        dp = new int [heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));
        bfsWithPQ(heights,dp, pq);
        //System.out.println(Arrays.deepToString(dp));
        return dp[heights.length-1][heights[0].length-1];
    }
    
    class Node implements Comparable<Node>{
        int cost;
        int row;
        int col;
        
        public Node(int cost, int row, int col) {
            super();
            this.cost = cost;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.cost-o.cost;
        }
    }
    
    private void bfsWithPQ(int[][] heights, int [][] dp, PriorityQueue<Node> pq){
        while(!pq.isEmpty()) {
            Node tmpNode = pq.poll();
            int i = tmpNode.row;
            int j = tmpNode.col;
            int cost = tmpNode.cost;
            
            if(i == heights.length-1 && j == heights[0].length-1){
                if (cost < dp[i][j]) dp[i][j] = cost;
                continue;
            }
            if (cost < dp[i][j]) dp[i][j] = cost;
            //up
            if (i > 0){
                int tmpcost = Math.max(Math.abs(heights[i-1][j] - heights[i][j]),cost);
                if (tmpcost < dp[i-1][j])
                    pq.add(new Node(tmpcost,i-1,j));
            }
            //down
            if (i < heights.length-1){
                int tmpcost = Math.max(Math.abs(heights[i+1][j] - heights[i][j]),cost);
                if (tmpcost < dp[i+1][j])
                    pq.add(new Node(tmpcost,i+1,j));
            }
                
            //left
            if (j > 0){
                int tmpcost = Math.max(Math.abs(heights[i][j-1] - heights[i][j]),cost);
                if (tmpcost < dp[i][j-1])
                    pq.add(new Node(tmpcost,i,j-1));
            }
            //down
            if (j < heights[0].length-1){
                int tmpcost = Math.max(Math.abs(heights[i][j+1] - heights[i][j]),cost);
                if (tmpcost < dp[i][j+1])
                    pq.add(new Node(tmpcost,i,j+1));
            }
        }
    }
}
