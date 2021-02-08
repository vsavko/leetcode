/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.
  Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:
Input: nums = [1]
Output: [1]
  Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100*/ 
class Solution {
       public static void nextPermutation(int[] nums) {
        boolean is_sorted_Reverse = true;
        int numSort = 0;
        
        //System.out.println(Arrays.toString(nums));
        for(int i = nums.length-2 ; i >= 0; i--){
            //System.out.println(i+ "i " + nums[i] + " " +nums[i+1]);
            if(nums[i] < nums[i+1]){
                //System.out.println(nums[i] + " " +nums[i+1]);
                is_sorted_Reverse = false;
                numSort = i;
                break;
            }
        }
        //System.out.println(is_sorted_Reverse);
        if (is_sorted_Reverse == true){
            for (int i = 0; i < nums.length / 2; i++) {
              int temp = nums[i];
              nums[i] = nums[nums.length - 1 - i];
              nums[nums.length - 1 - i] = temp;
            }
            return;
        }
        
        int minNum= Integer.MAX_VALUE ;
        int minPos = numSort;
        for(int i = numSort+1 ; i < nums.length; i++){
            if(nums[numSort] < nums[i] && nums[i] < minNum) {
                minNum = nums[i];
                minPos = i;
            }
        }
        
        int tmp = nums[numSort];
        nums[numSort] = nums[minPos];
        nums[minPos] = tmp;
        
        Arrays.sort(nums,numSort+1,nums.length);
    }
}
