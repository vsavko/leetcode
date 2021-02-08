/*Given an integer array nums, return the number of longest increasing subsequences.
Notice that the sequence has to be strictly increasing.
  Example 1:
Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
  Constraints:
1 <= nums.length <= 2000
-106 <= nums[i] <= 106*/ 
class Solution {
    public static int findNumberOfLIS(int[] nums) {
        int [] dp = new int[nums.length];
        int [] dpMaxSS = new int[nums.length];
        int maximum = 0;
        for (int i = 0; i < nums.length; i++){
            for(int j = i-1; j >=0; j--){
                if(dp[j] > dp[i] && nums[j] < nums[i]) {
                    dpMaxSS[i] = Math.max(1,dpMaxSS[j]);
                    dp[i] = dp[j];
                }
                else if(dp[j] == dp[i] && nums[j] < nums[i])
                    dpMaxSS[i] += Math.max(1,dpMaxSS[j]);
            }
            ++dp[i];
            if (dp[i] > maximum) maximum = dp[i];
        }
        //System.out.println(Arrays.toString(dp) + " " +maximum);
        //System.out.println(Arrays.toString(dpMaxSS));
        
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if(dp[i] == maximum ) {
                if(maximum > 1) {
                     ans += dpMaxSS[i];
                }
                else
                    ++ans;
            }
                
        }
        return ans;
    }
}
