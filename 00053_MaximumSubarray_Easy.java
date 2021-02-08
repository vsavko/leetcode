/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
  Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:
Input: nums = [1]
Output: 1
Example 3:
Input: nums = [0]
Output: 0
Example 4:
Input: nums = [-1]
Output: -1
Example 5:
Input: nums = [-100000]
Output: -100000
  Constraints:
1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105
  Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/ 
class Solution {
    public static int maxSubArray(int[] nums) {
        if (nums == null) return 0;
        //divide and conquer
        int max = findMaxDNC(nums, 0, nums.length - 1)[2];
        return max;
    }
    
    public static int[] findMaxDNC(int [] nums, int start, int end) {
        int [] returnArr = new int[4];
    
        if(end == start) {
            returnArr[0] = nums[start];
            returnArr[1] = nums[start];
            returnArr[2] = nums[start];
            returnArr[3] = nums[start];
            return returnArr;
        }
        
        int arrLengthLeft = (end - start)/2;
        
        int [] left = findMaxDNC(nums, start, start + arrLengthLeft );
        int [] right = findMaxDNC(nums, start + arrLengthLeft+1, end );
        
        //int[0] - left max 
        //int[1] - right max
        //int[2] - array max
        //int[3] - total sum
        returnArr[0] = Math.max(left[0], left[3] + right[0]);
        returnArr[1] = Math.max(right[1], right[3] + left[1]);
        returnArr[2] = Math.max(left[1]+ right[0], Math.max(left[2],right[2]));
        returnArr[3] = left[3] + right[3];
        
        return returnArr;
    }
}
