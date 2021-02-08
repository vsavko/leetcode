/*You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
  Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
  Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.*/ 
class Solution {
    public int orangesRotting(int[][] grid) {
        //HashSet rotten oranges position
        //Number of good oranges
        //HashSet of possible fields to go (good oranges)
        
        //if HashSet is out of rotten oranges and HashSet of good ones size > 0 then 
            impossible
        //if  HashSet of good ones == 0 return the turn
        HashSet<Integer> good = new HashSet<>();
        HashSet<Integer> bad = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1) good.add(i*11+j);
                if (grid[i][j] == 2) bad.add(i*11+j);
            }
        }
        
        int turn = 0;
        while(bad.size() > 0 && good.size() > 0 ){
            HashSet<Integer> tmpBad = new HashSet<>();
            for(Integer key : bad){
                //up          
                if(good.contains(key - 11)){
                    good.remove(key - 11);
                    tmpBad.add(key - 11);
                }
                    
                //down
                if(good.contains(key + 11)){
                    good.remove(key + 11);
                    tmpBad.add(key + 11);
                }
                
                //left
                if(good.contains(key - 1)){
                    good.remove(key - 1);
                    tmpBad.add(key - 1);
                }
                
                //right
                if(good.contains(key + 1)){
                    good.remove(key + 1);
                    tmpBad.add(key + 1);
                }
            }
            bad = tmpBad;
            ++turn;
        }
        
        return (good.size() > 0) ? -1 : turn;
    }

