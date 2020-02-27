/*Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.*/

public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		if (nums == null) return 0;
		
	    //while array positive continue with it
		//if negative look for new
		//keep start and end of currently max array

		int max = Integer.MIN_VALUE, current = 0;
		for(int i = 0; i < nums.length; i++) {
			current += nums[i];
			if (max < current) {
				max = current;
			}
			if (current < 0) {
				current = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int [] arr2 = {-5,7,-5,-23,1};
		int [] arr3 = {-1,-2,-4};
		System.out.println(maxSubArray(arr));
		System.out.println(maxSubArray(arr2));
		System.out.println(maxSubArray(arr3));
	}
}
