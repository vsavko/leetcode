/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	//table dimentions for iteration
	int n = obstacleGrid.length;
    int m = obstacleGrid[0].length;
  
        for(int j = m-1; j >= 0 ; j--) { //iterate through table length - m
            for(int i = n-1; i >= 0; i--) { //iterate through table height - n
			
            	if (obstacleGrid[i][j] == 1) { //if obstacle found, make cell value 0, so it contains no paths
            		obstacleGrid[i][j] = 0;
            		continue;
            	}
            	
            	if (j == m-1 && i == n-1) obstacleGrid[i][j] = 1; //finish cell
            	
            	else {
            		if(j < m -1) obstacleGrid[i][j] += obstacleGrid[i][j+1]; //add  right paths
            		if(i < n -1) obstacleGrid[i][j] += obstacleGrid[i+1][j]; //add bottom paths
            	}
            }
        }
        return obstacleGrid[0][0];
    }
}
