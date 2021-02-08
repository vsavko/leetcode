/*Given an array, rotate the array to the right by k steps, where k is non-negative.
Follow up:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?
  Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
  Constraints:
1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105*/ 
class Solution {
    /*public void rotate(int[] nums, int k) {
        if(nums.length <= 1 || k == 0) return;
        k = k % nums.length;
        for( ; k > 0; k--){
            int tmp = nums[0];
            for(int i = 1; i <= nums.length; i++){
                int tmp2 = nums[i%nums.length];
                nums[i%nums.length] = tmp;
                tmp = tmp2;
            }
        }
    }*/
    
    /*public void rotate(int[] nums, int k){
        int [] tmp = new int [nums.length];
        k %= nums.length;
        int j = 0;
        
        for(int i = nums.length - k; i < nums.length; i++){
            tmp[j++] = nums[i];
        }

        for(int i = 0; i < nums.length - k; i++){
            tmp[j++] = nums[i];
        }
        
        //System.out.println(Arrays.toString(tmp));
        System.arraycopy(tmp, 0 , nums, 0, nums.length);

    }*/
    
        public void rotate(int[] nums, int k){
        if(nums.length <= 1 || k%nums.length == 0) return;
            
        k %= nums.length;
        int space_left = nums.length;
        int j = 0;
            
        while (k % space_left > 0){
            k %= space_left;
            for(int i = nums.length - k; i < nums.length; i++){
                int tmp = nums[j];
                nums[j++] = nums[i];
                nums[i] = tmp;
            }
            space_left -= k;
            //System.out.println(Arrays.toString(nums));
        }
    }
}
