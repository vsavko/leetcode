/*Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.
Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the O(n) solution?
  Example 1:
Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:
Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:
Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
  Constraints:
n == nums.length
1 <= n <= 104
-109 <= nums[i] <= 109*/ 
class Solution {
    public boolean find132pattern(int[] nums) {
        int ptr3 = nums.length-1;
        int maxVal = Integer.MIN_VALUE;
        int maxVal2 = Integer.MIN_VALUE;
        int maxVal2Tmp = Integer.MIN_VALUE;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] < maxVal2)
                return true;
            if (nums[i] > maxVal2Tmp && nums[i] < maxVal)
                maxVal2Tmp = nums[i];
            if(ptr3 == nums.length-1 && nums[i] <= nums[i+1]) 
                --ptr3;
            if(nums[i] > nums[i+1]){
                if (nums[i] > maxVal){
                    maxVal2 = maxVal;
                    maxVal = nums[i];
                }
                while(ptr3 < nums.length){
                    if (nums[ptr3] < maxVal ){
                        if (nums[ptr3] > maxVal2)
                            maxVal2 = nums[ptr3];
                        ptr3++;
                    }
                    else
                        break;
                }
                if (nums[i] == maxVal)
                    maxVal2 = Math.max(maxVal2Tmp,maxVal2);
            }
        }
        return false;
    }
}
