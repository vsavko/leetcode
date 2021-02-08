/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.
  Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
  Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.*/ 
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        //int [][] arr = new int [n][m];
  
        for(int j = m-1; j >= 0 ; j--) { //length - m
            
            for(int i = n-1; i >= 0; i--) { //height - n
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                
                if (j == m-1 && i == n-1) obstacleGrid[i][j] = 1;
                
                else {
                    if(j < m -1) obstacleGrid[i][j] += obstacleGrid[i][j+1];
                    if(i < n -1) obstacleGrid[i][j] += obstacleGrid[i+1][j];
                }
            }
        }
        return obstacleGrid[0][0];
    }
}
