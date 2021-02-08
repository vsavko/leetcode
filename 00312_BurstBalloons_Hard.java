/*You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.
  Example 1:
Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:
Input: nums = [1,5]
Output: 10
  Constraints:
n == nums.length
1 <= n <= 500
0 <= nums[i] <= 100*/ 
class Solution {
    public int maxCoins(int[] nums) {
        int [] nums2 = new int[nums.length+2];
        for(int i = 0; i < nums.length; i++) {
            nums2[i+1] = nums[i];
        }
        nums2[0] = nums2[nums.length+1] = 1;
        int [][] dp = new int [nums.length+2][nums.length+2];
        for(int k = 1; k <= nums.length; k++) {
            for(int left = 0; left <= nums.length -k; left++) {
                int right = left + k + 1;
                for(int j = left +1; j < right; j++) {
                    dp[left][right] = Math.max(dp[left][right], 
                            nums2[left]*nums2[j]*nums2[right] + dp[left][j] + dp[j][right]);
                }
            }
        }
        return dp[0][nums2.length-1];
    }
}
