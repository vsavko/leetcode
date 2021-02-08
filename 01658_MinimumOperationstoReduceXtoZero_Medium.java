/*You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
  Example 1:
Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:
Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:
Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
  Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109*/ 
class Solution {
  public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,0);
        int sum = 0;
        int ans = -1;
        for (int i = nums.length-1; i>=0; i--){
            sum += nums[i];
            hm.put(sum, nums.length - i);
            if (sum == x) ans = nums.length - i;
        }
        sum = 0;
       // System.out.println(hm);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (hm.containsKey(x - sum)){
                //System.out.println(hm.get(x - sum) + i);
                if (hm.get(x - sum) + i < nums.length){
                    if (ans == -1) ans = hm.get(x - sum) + i +1;
                    else ans = Math.min(ans, hm.get(x - sum) + i +1);
                }
            }
        }
        return ans;
    }
}
