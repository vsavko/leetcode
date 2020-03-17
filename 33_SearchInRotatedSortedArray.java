/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1; //corner cases   
        return searchRecursivly(0, nums.length-1, target, nums); //search right  
    }
    
    public int searchRecursivly(int start, int end, int target, int [] nums){
        if(start > end) return -1;
        int mid = (end - start +1)/2 + start;
        if (nums[mid] == target) return mid;
        
        int left = searchRecursivly(start, mid-1, target, nums); //search left
        if (left != -1) return left;

        //case2 - right (smaller) array 
        return searchRecursivly(mid+1, end, target, nums); //search right
    }
}
