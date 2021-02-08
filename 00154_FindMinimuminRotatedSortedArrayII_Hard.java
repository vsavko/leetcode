/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
The array may contain duplicates.
Example 1:
Input: [1,3,5]
Output: 1
Example 2:
Input: [2,2,2,0,1]
Output: 0
Note:
This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?*/ 
class Solution {
    public static int findMin(int[] nums) {
        return recursiveBin(nums, 0, nums.length-1);
    }
    
    private static int recursiveBin(int [] nums, int start, int end) {
        if (start >= end) return nums[start];
        int mid = (start + end) / 2;
        //System.out.println(start + " " + mid + " " + end);
        if(nums[mid] > nums[end]) {
            return recursiveBin(nums, mid + 1, end);
        }
        else if (nums[mid] < nums[end]) {
            return recursiveBin(nums, start, mid);
        }
        else { //when equal
            return Math.min(recursiveBin(nums, mid + 1, end), recursiveBin(nums, start, mid - 
                1));
        }
    }
}
