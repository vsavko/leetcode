/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
  Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:
Input: nums = [0]
Output: [0]
Example 4:
Input: nums = [1]
Output: [1]
  Constraints:
n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
  Follow up:
Could you solve this problem without using the library's sort function?
Could you come up with a one-pass algorithm using only O(1) constant space?*/ 
class Solution {
    public void sortColors(int[] nums) {
        int ptr0 = 0, ptr2 = nums.length -1;
        int tmp = 0;

        while(ptr0 < ptr2 && tmp < ptr2){
            if (nums[ptr0] == 0){
                ptr0++;
            }
            else if (nums[ptr2] == 2 ){
                ptr2--;
            } 
            else if(nums[ptr0] == 2){
               nums[ptr0] = nums[ptr2];
               nums[ptr2--] = 2;
            } 
            else if(nums[ptr2] == 0){
               nums[ptr2] = nums[ptr0];
               nums[ptr0++] = 0;
            }
            else if(nums[ptr0] == 1 && nums[ptr2] == 1){
                if (tmp == 0 ) tmp = ptr0 +1;
                else tmp += 1;

                if (nums[tmp] == 0) {
                    nums[ptr0++] = 0;
                    nums[tmp] = 1;
                }
                if(nums[tmp] == 2){
                    nums[ptr2--] = 2;
                    nums[tmp] = 1;
                }

            }
            
        }
    }
}