/*Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
  Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0
Example 5:
Input: nums = [1], target = 0
Output: 0
  Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104*/ 
class Solution {
    public static int searchInsert(int[] nums, int target) {
        //bin search
        int mid = -1, start = 1, end = nums.length;
        if (target <= nums[0]) return 0;
        if (target > nums[nums.length-1]) return nums.length;
        while(start <= end){
            mid = (start + end) /2;

            if(target > nums[mid-1] && target <= nums[mid]){
                return mid;
            }
            else if(target > nums[mid]) start = mid +1;
            else end = mid -1;
        }
        return mid;
    }
    
}
