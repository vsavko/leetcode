/*Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.
  Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
  Constraints:
1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105*/ 
class Solution {
    public int jump(int[] nums) {
        //make a dp table
        //go from the end, if we can reach end, put 1 for that position and 
        //go to next position
        //if less then 1 move, apply greedy tactics and stop if 2 moves
        int [] dp = new int[nums.length];
        
        for(int i = nums.length-2; i >= 0 ; i--) {
            int movesToFinish = nums.length - 1 - i;
            if(nums[i] >= movesToFinish) { 
                    dp[i] = 1;
                    continue;
            }
            else {
                int minMoves = nums.length;
                dp[i] = minMoves;
                for(int j = nums[i]; j > 0; j--) {
                    if (dp[i+j] == 1) { dp[i] = 2;
                        break;
                    }
                    else {
                        if(minMoves > dp[i+j] + 1) {
                            minMoves = dp[i+j] + 1;
                            dp[i] = minMoves;
                        }
                    }
                }
            }           
        }
        return dp[0];
    }
    
}
