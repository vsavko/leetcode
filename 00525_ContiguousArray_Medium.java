/*Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.*/ 
class Solution {
    public static int findMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        HashMap<Integer,Integer> hm = new HashMap<>(); //ones - zeros, arraylist of positions
        int sum = 0;
        for(int i = nums.length -1; i >= 0; i-- ) {
            sum += (nums[i] == 0 ? -1 : 1);
            if(!hm.containsKey(sum)) {
                hm.put(sum,i);
            }
        }
        if (sum == 0) return nums.length;
        int totalSum = sum, max = 0;
        sum = 0;
        for(int i = 0; i < nums.length; i++) {
            
            int rest = totalSum - sum;
            if (rest == 0) {
                if (max < nums.length - i ) 
                    max = nums.length - i;
            }
            if (hm.containsKey(rest)) {
                int tmp = hm.get(rest) - i ;
                if( tmp > max) max = tmp;
            }
            sum += (nums[i] == 0 ? -1 : 1);
        }
        return max;
    }
}
