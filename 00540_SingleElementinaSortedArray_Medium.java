/*You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
Follow up: Your solution should run in O(log n) time and O(1) space.
  Example 1:
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: nums = [3,3,7,7,10,11,11]
Output: 10
  Constraints:
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^5*/ 
class Solution {
    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length-1] != nums[nums.length-2]) return nums[nums.length-1];
        //bin sort 
        //first of pair should be even
        //second - odd
        int start = 0; int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            //System.out.println(start + " " + mid + " " + end);
            if (nums[mid-1] != nums[mid] && nums[mid] != nums[mid +1])
                return nums[mid];
            if (mid %2 == 0) {
                if (nums[mid+1] == nums[mid]) { //go up
                    start = mid +2;
                }
                else
                    end = mid - 2; //go down
            }
            else {
                if (nums[mid+1] == nums[mid]) { //go down
                    end = mid -1;
                }
                else
                    start = mid + 1; //go up
            }           
        }
        return -1;
    }  
}
