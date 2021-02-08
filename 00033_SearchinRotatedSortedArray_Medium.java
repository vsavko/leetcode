/*You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.
Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
If target is found in the array return its index, otherwise, return -1.
  Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:
Input: nums = [1], target = 0
Output: -1
  Constraints:
1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104*/ 
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1; //corner cases   
        return searchRecursivly(0, nums.length-1, target, nums); //search right  
    }
    
    public int searchRecursivly(int start, int end, int target, int [] nums){
        if(start > end) return -1;
        int mid = start + (end - start)/2;
        if (nums[mid] == target) return mid;
        
        int left = searchRecursivly(start, mid-1, target, nums); //search left
        if (left != -1) return left;

        //case2 - right (smaller) array 
        return searchRecursivly(mid+1, end, target, nums); //search right
    }
}
