/*Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.
  Example 1:
Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:
Input: nums = [1,2,4,8]
Output: [1,2,4,8]
  Constraints:
1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
All the integers in nums are unique.*/ 
class Solution {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();

        if (nums.length == 0) return ans;
        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }

        int [][] dp = new int [nums.length][2];
        dp[0][1] = 1; //dp[][1] == length of max subarray
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = -1;
            dp[i][1] = 1;
        }
        
        int maxSubArrayPtr = 0;
        int maxSubArrrLen = 0;
        for(int i = 1; i < nums.length; i++) {
            for(int j = i-1; j >=0 ; j--) {
                if(nums[i] % nums[j] == 0) {

                    if(dp[i][1] < dp[j][1] + 1) {
                        dp[i][1] = dp[j][1] + 1;
                        dp[i][0] = j;
                        //if(nums[i] == 27)
                        //  System.out.println(nums[i] + " maxSubArrrLen " + maxSubArrrLen + " 
                            dp[i][1] " + dp[i][1]);
                    }
                    if(maxSubArrrLen < dp[i][1]) {
                        maxSubArrrLen = dp[i][1];
                        maxSubArrayPtr = i;
                    }
                }
            }
            
        }
        
        ans = new ArrayList<>();
        //System.out.println(maxSubArrayPtr);
        //System.out.println(Arrays.deepToString(dp));
        while(maxSubArrayPtr != -1) {
            ans.add(nums[maxSubArrayPtr]);
            maxSubArrayPtr = dp[maxSubArrayPtr][0];
            //System.out.println(maxSubArrayPtr);
        }
        
        return ans;
    }
}
