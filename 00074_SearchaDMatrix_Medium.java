/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
  Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
  Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104*/ 
class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            //bin search cols then rows
            if(matrix.length ==0 || matrix[0].length ==0) return false;
            return bin_search_row(bin_search_col(matrix, target),target);
            
        }
        
        private int [] bin_search_col (int [][] matrix, int value){
            int start = 0, end = matrix.length -1;
            int mid = 0;
            while (start <= end){
                mid = start + (end-start) / 2;
                if (value >= matrix[mid][0] && value <= matrix[mid][matrix[mid].length-1])
                    return matrix[mid];
                else if(value > matrix[mid][matrix[mid].length-1])
                    start = mid +1;
                else
                    end = mid -1;
            }
            return matrix[mid];
        }
        
            private boolean bin_search_row (int [] row, int value){
            int start = 0, end = row.length - 1;
            while (start <= end){
                int mid = start + (end-start) / 2;
                if (value == row[mid])
                    return true;
                else if(value > row[mid])
                    start = mid +1;
                else
                    end = mid -1;
            }
            return false;
        }
}
