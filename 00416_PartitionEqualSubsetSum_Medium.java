/*Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
  Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
  Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100*/ 
class Solution {
     public boolean canPartition(int[] nums) {
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            leftSum += nums[i];
        }
        if (leftSum % 2 == 1) return false;
        int targetSum = leftSum/2;
        HashSet<Integer> possibleValues = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == targetSum) return true;
            HashSet<Integer> tmp = new HashSet<>();
            for(Integer num: possibleValues) {
                tmp.add(num + nums[i]);
                if(num + nums[i] == targetSum)
                    return true;
            }
            possibleValues.addAll(tmp);
            possibleValues.add(nums[i]);
        }
        return false;
    }

}
