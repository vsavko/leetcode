/*Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
  Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:
Input: n = 1
Output: [[1]]
  Constraints:
1 <= n <= 20*/ 
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] ans = new int[n][n];
        int row = 0;
        int col = 0;
        int num = 1;
        while(col < n && ans[row][col] == 0){
            //go right

            while(col < n && ans[row][col] == 0)
                ans[row][col++] = num++;
            
            --col;
            ++row;

            //go down
            while(row < n && ans[row][col] == 0)
                ans[row++][col] = num++;

            --row;
            --col;

            //go left
            while(col >= 0 && ans[row][col] == 0)
                ans[row][col--] = num++;
            
            ++col;
            --row;

             //go up
            while(row >= 0 && ans[row][col] == 0)
                ans[row--][col] = num++;

            ++row;
            ++col;
        }
        return ans;
    }
    
    
}
