/*Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
  Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:
  Note:
The total number of elements of the given matrix will not exceed 10,000.*/ 
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if( matrix.length == 0 || matrix[0].length == 0 )
            return new int[0];
        int row = 0;
        int col = 0;
        boolean isUpDiagonal = true;
        int [] ans = new int [matrix.length*matrix[0].length];
        
        for(int i = 0; i < matrix.length*matrix[0].length; i++){
            
            if(isUpDiagonal){
                ans[i] = matrix[row--][col++];
                if(row < 0 || col >= matrix[0].length){
                    isUpDiagonal = !isUpDiagonal;
                    if(col >= matrix[0].length){
                        --col;
                        row += 2;
                    }
                    else
                        ++row; 
                }
            }
            else{
                ans[i] = matrix[row++][col--];
                if(row >=  matrix.length || col <0 ){
                    isUpDiagonal = !isUpDiagonal;
                    if(row >=  matrix.length){
                        --row;
                        col += 2;
                    }
                    else
                        ++col; 
                }
            }
        }
        
        return ans;
    }
}
