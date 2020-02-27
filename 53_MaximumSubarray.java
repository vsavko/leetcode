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
	
	public static int maxSubArray2(int[] nums) {
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
	
	
	public static void main(String[] args) {
		int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int [] arr2 = {-5,7,-5,-23,1};
		int [] arr3 = {-1,-2,-4,1};
		System.out.println(maxSubArray(arr));
		System.out.println(maxSubArray(arr2));
		System.out.println(maxSubArray(arr3));
		
		System.out.println(maxSubArray2(arr));
		System.out.println(maxSubArray2(arr2));
		System.out.println(maxSubArray2(arr3));
	}
}
