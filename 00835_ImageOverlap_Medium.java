/*You are given two images img1 and img2 both of size n x n, represented as binary, square matrices of the same size. (A binary matrix has only 0s and 1s as values.)
We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
(Note also that a translation does not include any kind of rotation.)
What is the largest possible overlap?
  Example 1:
Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
Output: 3
Explanation: We slide img1 to right by 1 unit and down by 1 unit.

The number of positions that have a 1 in both images is 3. (Shown in red)
Example 2:
Input: img1 = [[1]], img2 = [[1]]
Output: 1
Example 3:
Input: img1 = [[0]], img2 = [[0]]
Output: 0
  Constraints:
n == img1.length
n == img1[i].length
n == img2.length
n == img2[i].length
1 <= n <= 30
img1[i][j] is 0 or 1.
img2[i][j] is 0 or 1.*/ 
class Solution {

        public int largestOverlap(int[][] A, int[][] B) {
            int [] binA = new int[A.length];
            int [] binB = new int[B.length];
            int ans = 0;
            
            for(int i = 0; i < A.length; i++){
                for (int j = 0; j < A.length; j++) {
                    binA[i] <<= 1;
                    binB[i] <<= 1;
                    binA[i] = binA[i] | A[i][j];
                    binB[i] = binB[i] | B[i][j];
                }
            }
            
            //System.out.println(Arrays.toString(binA));
            //System.out.println(Arrays.toString(binB)); 
            for(int i = 0; i <= 2*A.length -2; i++){
                //starting
                int rowA = Math.max(0, A.length - 1 - i);
                int rowB = Math.max(0, i - A.length + 1);
                int maskA = 0;
                int maskB = 0;
                //System.out.println("rowA" + rowA + "rowB" + rowB);
                for(int j = 0; j <= 2*A.length -2; j++){
                    int rA = rowA;
                    int rB = rowB;
                    //for A first we add bits from right to left with a mask
                    //then we delete bits from the right with a shift
                    
                    //for B first we add bits from the left with a diminishing shift to the 
                        right
                    //then we destroy bits from the left with a mask
                    if (j < A.length){
                        maskA <<= 1;
                        maskA |= 1;
                    }
                    else{
                        maskB = (~(1 << (2*A.length - j -1)));
                    }
                    
                    //System.out.println(i + " " + j + " " + Integer.toBinaryString(maskA) + " 
                        " + Integer.toBinaryString(maskB));
                    int tmp = 0;
                    while (rA < A.length && rB < A.length){
                        
                        /*if (rowA == 0 && rowB == 1 && j == 3) {
                            System.out.println("Column" + j);
                        System.out.println("Ra " + binA[rA] + " " + binB[rB] );
                        System.out.println("maskA" + Integer.toBinaryString(maskA) + " mskB " 
                            + Integer.toBinaryString(maskB));
                        System.out.println(Integer.toBinaryString(binA[rA]&maskA) + " " + 
                            Integer.toBinaryString(binB[rB]&maskB));
                        }*/
                        int num1 = 0, num2 = 0;
                        if (j < A.length) {
                            num1 = binA[rA] & maskA;
                            num2 = binB[rB] >> A.length - j -1;
                        }
                        else {
                            num1 = binA[rA] >> (j - A.length +1);
                            num2 = binB[rB] & maskB;
                        }
                        
                        
                        tmp += Integer.bitCount((num1)&(num2));
                        if (rowA == 0 && rowB == 1 && j == 3) {
                            /*System.out.println(binA[rA] + " " + binB[rB] + " " + Integer
                                .toBinaryString(maskB));
                            System.out.println("num1 " + num1 + "num2 " + num2);
                            System.out.println("TEMP " + tmp);*/
                        }
                        rA++;
                        rB++;
                    }
                    //System.out.println(tmp);
                    ans = Math.max(ans,tmp);
                }       
            }
            return ans;
        }
        
    
}
