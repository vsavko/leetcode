/*We write the integers of A and B (in the order they are given) on two separate horizontal lines.
Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
A[i] == B[j];
The line we draw does not intersect any other connecting (non-horizontal) line.
Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
Return the maximum number of connecting lines we can draw in this way.
  Example 1:
Input: A = [1,4,2], B = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
Example 2:
Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
Output: 3
Example 3:
Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
Output: 2
  Note:
1 <= A.length <= 500
1 <= B.length <= 500
1 <= A[i], B[i] <= 2000*/ 
class Solution {
    public static int maxUncrossedLines(int[] A, int[] B) {
        int [][] dp = new int [B.length][A.length];
        int max = 0;
        //col is A values
        //row is B values
        //dp last row
        for(int col = A.length - 1; col >= 0; col--) {
            if(A[col] == B[B.length-1]) 
                dp[B.length-1][col] = 1;
            else if(col < A.length - 1)
                dp[B.length-1][col] = dp[B.length-1][col+1];
            else
                dp[B.length-1][col] = 0;
            
            if (dp[B.length-1][col] > max) max = dp[B.length-1][col];
        } 
        
        //dp last col
        for(int row = B.length - 1; row >= 0; row--) {
            if(B[row] == A[A.length-1]) 
                dp[row][A.length-1] = 1;
            else if(row < B.length - 1)
                dp[row][A.length-1] = dp[row+1][A.length-1];
            else
                dp[row][A.length-1] = 0;
            
            if (dp[row][A.length-1] > max) max = dp[row][A.length-1];
        }
        
        //fill other fields
        for(int row = B.length - 2; row >= 0; row--) {
            for(int col = A.length - 2; col >= 0; col--) {

                int i = row;
                while(i <  B.length  && A[col] != B[i]) i++;


                if( i == B.length) {
                    dp[row][col] = dp[row][col+1];
                }
                else if (i < B.length-1) {
                    dp[row][col] = 1 + dp[i+1][col+1];
                }
                else
                    dp[row][col] = 1;
                
                dp[row][col] = Math.max(dp[row][col], dp[row][col+1]);
                
                if (dp[row][col] > max) max = dp[row][col];
            }
        }
       /*for(int row = 0; row < B.length; row++) {
            for(int col = 0; col < A.length; col++) {
                System.out.print(dp[row][col]+ " ");
            }
            System.out.println();
        }*/

        return max;
    }
}
