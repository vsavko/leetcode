/*Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
  Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
  Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
  Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?*/ 
class Solution {
    public int[] sortedSquares(int[] A) {
        //find the min abs value
        //use left and right pointers
        int minVal = Integer.MAX_VALUE;
        int pos = 0;
        for(int i = 0; i < A.length; i++){
            if(Math.abs(A[i]) < minVal){
                minVal = Math.abs(A[i]);
                pos = i;
            }
        }
        int posLeft = pos;
        int posRight = pos +1;
        int [] ans = new int [A.length];
        int j = 0;
        while(posLeft>= 0 || posRight < A.length){
            if (posLeft <0){
                ans[j++] = A[posRight]*A[posRight];
                posRight++;
            }
            else if (posRight == A.length){
                ans[j++] = A[posLeft]*A[posLeft];
                posLeft--;
            }
            else{
                if(Math.abs(A[posLeft]) < Math.abs(A[posRight])){
                    ans[j++] = A[posLeft]*A[posLeft];
                    posLeft--;
                }
                else{
                    ans[j++] = A[posRight]*A[posRight];
                    posRight++;
                }
            }
        }
        return ans;
    }
}
