/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
Return the max sliding window.
  Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:
Input: nums = [1], k = 1
Output: [1]
Example 3:
Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:
Input: nums = [9,11], k = 2
Output: [11]
Example 5:
Input: nums = [4,-2], k = 2
Output: [4]
  Constraints:
1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length*/ 
class Solution {
       
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> windowIndex = new LinkedList<>();
        int [] ans = new int[nums.length-k+1];
        
        for(int i = 0; i < nums.length; i++){
            
            if(windowIndex.size() > 0 && i >= k && i-k >= windowIndex.peek() ) {
                //System.out.println(windowIndex.peek() + " i-k " + (i-k));
                windowIndex.poll();
            }
            
            while(windowIndex.size() > 0 && nums[i] > nums[windowIndex.getLast()]) 
                windowIndex.pollLast();
            
            windowIndex.addLast(i);
            
            //System.out.println(windowIndex);
            if(i >= k - 1)
                ans[i-k+1] = nums[windowIndex.peek()];
        }
        return ans;
    }
}
