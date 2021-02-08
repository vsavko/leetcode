'''Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 ≤ i ≤ j < n.
Follow up: Could you do this in O(n) runtime?
  Example 1:
Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:
Input: nums = [0]
Output: 0
Example 3:
Input: nums = [2,4]
Output: 6
Example 4:
Input: nums = [8,10,2]
Output: 10
Example 5:
Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
  Constraints:
1 <= nums.length <= 2 * 104
0 <= nums[i] <= 231 - 1''' 
from typing import List


class Solution:
    def findMaximumXOR(self, nums: List[int]) -> int:
        # A ^ B = C
        # for every digit in numbers we check if there are 2 prefixes to give the max possible
        mask = 0
        ans = 0
        for i in range(30, -1, -1):
            mask |= 1 << i
            st = set()
            for num in nums:
                st.add(num & mask)

            tmp = ans | 1 << i
            for s in st:
                if tmp^s in st:  # tmp is the max possible answer, if A^tmp = B and B is found
                    ,
                    # then A^B = tmp is true and such combo exists
                    ans = tmp
                    break
        return ans

