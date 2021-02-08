/*You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.
  Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
  Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109*/ 
class Solution {
    public int maxOperations(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(Integer num : nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(Integer num : nums){
           if(hm.containsKey(k-num)){
               int numKeys = hm.get(k-num);
               if(k-num == num){
                   if (numKeys > 1){
                       ++ans;
                       hm.put(num,numKeys-2);
                   }
               }
               else{
                   if(numKeys > 0 && hm.get(num) > 0){
                        ++ans;
                       hm.put(k-num, numKeys-1);
                       hm.put(num, hm.get(num)-1);
                   }
                }
           }
        }
        return ans;
    }
}
