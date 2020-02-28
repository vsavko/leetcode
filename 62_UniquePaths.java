/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28*/

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int [][] arr = new int [m][n];
        
        for(int j = m-1; j >= 0 ; j--) { //height - m
            for(int i = n-1; i >= 0; i--) { //length - n
            	
            	if (j == m-1 && i == n-1) arr[j][i] = 1;
            	
            	else {
            		if(i < n -1) arr[j][i] += arr[j][i+1];
            		if(j < m -1) arr[j][i] += arr[j+1][i];
            	}
            }
        }
        return arr[0][0];
    }
    
    public static void main(String[] args) {
		System.out.println(uniquePaths(7,3));
	}
}
