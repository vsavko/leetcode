'''Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
  Example 1:
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
  Constraints:
0 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1''' 
from typing import List
from sortedcontainers import SortedList


class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        if t < 0:
            return False
        s = SortedList()
        for i in range(0, len(nums)):
            # print(s)
            if i > k:
                numToDelete = nums[i - k-1]

                s.remove(numToDelete)
            # print(s)
            if s.__contains__(nums[i]):
                # print("yea")
                return True
            s.add(nums[i])
            pos = s.index(nums[i])
            # print(s, pos)
            if pos > 0:
                tmp = s.__getitem__(pos-1)
                # print(tmp)
                if abs(nums[i] - tmp) <= t:
                    return True
            if pos < len(s)-1 :
                tmp = s.__getitem__(pos+1)
                # print(tmp)
                if abs(nums[i] - tmp) <= t:
                    return True

        return False
