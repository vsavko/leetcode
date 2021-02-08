/*Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
  Example 1:
Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:
Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
  Constraints:
1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1*/ 
class Solution {
    public static int countSquares(int[][] matrix) {

        int totalSquares = 0;
        //fill last col
        for(int row = matrix.length -1; row >=0; row--) {
            if (matrix[row][matrix[0].length-1] == 1 ) ++totalSquares;
        }
        
        //fill last row
        for(int col = matrix[0].length -2; col >=0; col--) {
            if (matrix[matrix.length-1][col] == 1 ) ++totalSquares;
        }
        
        //fill other cells
        
        for(int row = matrix.length -2; row >=0; row--) {
            for(int col = matrix[0].length -2; col >=0; col--) { 
                if (matrix[row][col] != 0) {
                    matrix[row][col] = Math.min(matrix[row+1][col], Math.min(matrix[row+1][col
                        +1], matrix[row][col+1])) +1;
                    totalSquares += matrix[row][col];
                }
            }
        }
        return totalSquares;
    }
    
}
