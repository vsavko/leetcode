/*You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
  Example 1:
Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:
Input: nums = [0]
Output: 0
  Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 1000*/ 
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        
        int day_minus2_withFirst = nums[0];
        int day_minus1_withFirst = Math.max(nums[0],nums[1]);
        int day_minus2_withoutFirst = 0;
        int day_minus1_withoutFirst = nums[1];
        int max1 = day_minus1_withFirst;
        int max2 = nums[1];
        
        //System.out.println( day_minus2_withFirst + " " + day_minus1_withFirst);
        
        for (int i = 2; i < nums.length; i++){
            if(i < nums.length -1){
                max1 = Math.max(day_minus2_withFirst + nums[i], day_minus1_withFirst);
                day_minus2_withFirst = day_minus1_withFirst;
                day_minus1_withFirst = max1;
            }
            
            max2 = Math.max(day_minus2_withoutFirst + nums[i], day_minus1_withoutFirst);
            day_minus2_withoutFirst = day_minus1_withoutFirst;
            day_minus1_withoutFirst = max2;
            
            //System.out.println(i + " " + max1 + " " + max2);
        }
        //System.out.println(max1 + " " + max2);
        return Math.max(max1, max2);
    }
}
