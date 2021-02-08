/*Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
  Example 1:
Input: nums = [3,2,3]
Output: 3
Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
  Constraints:
n == nums.length
1 <= n <= 5 * 104
-231 <= nums[i] <= 231 - 1
  Follow-up: Could you solve the problem in linear time and in O(1) space?*/ 
class Solution {
            public int majorityElement(int[] nums) {
            return findMajority(nums, 0, nums.length).val;
        }
        
        private class ReturnAns{
            public int val;
            public int freq;
            
            public ReturnAns(int val, int freq) {
                this.val = val;
                this.freq = freq;
            }
    
        }
        
        public ReturnAns findMajority(int [] nums, int start, int len){
            if (len == 1) {
                return (new ReturnAns(nums[start],1));
            }
            
            ReturnAns left = findMajority(nums, start, len/2);
            ReturnAns right = findMajority(nums, start + len/2, len - len/2);
            
            //if(len == nums.length)
           // System.out.println(start + " " + len + " " + left.val + " " + left.freq + " "  + 
               right.val + " " + right.freq);

            if (left.val == right.val) return (new ReturnAns(left.val, left.freq + right.freq
                ));
            else { //check left
                int leftMax = left.freq;
                int rightMax = right.freq;
                
               // System.out.println(start);
                
                for(int i = start;i < start + len/2; i++){
                    
                    if (nums[i] == right.val) ++rightMax;
                }
                
                for(int i = start+len/2; i < start + len; i++){
                    //System.out.println(i + "nums[i] " + nums[i]);
                    if (nums[i] == left.val) ++leftMax;
                }
                
               // System.out.println(leftMax + " rightMax " + rightMax );
                return (rightMax > leftMax) ? new ReturnAns(right.val, rightMax) : new 
                    ReturnAns(left.val, leftMax);
            } 
        }

}
