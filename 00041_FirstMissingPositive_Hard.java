/*Given an unsorted integer array nums, find the smallest missing positive integer.
  Example 1:
Input: nums = [1,2,0]
Output: 3
Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
  Constraints:
0 <= nums.length <= 300
-231 <= nums[i] <= 231 - 1
  Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space?*/ 
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int curPtr = i;
            int val = -1;
            while(curPtr >= 0 && curPtr < nums.length && nums[curPtr] != curPtr+1){
                int tmp = nums[curPtr];
                if (val != -1)
                    nums[curPtr] = val;
                curPtr = tmp-1;
                val = tmp;
            }
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != i+1)
                return i+1;
        }
        return nums.length+1;
    }
}
