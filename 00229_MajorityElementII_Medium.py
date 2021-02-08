'''Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Follow-up: Could you solve the problem in linear time and in O(1) space?
  Example 1:
Input: nums = [3,2,3]
Output: [3]
Example 2:
Input: nums = [1]
Output: [1]
Example 3:
Input: nums = [1,2]
Output: [1,2]
  Constraints:
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109''' 
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        dct = {}
        for n in nums:
            if n in dct:
                dct[n] += 1
            else:
                dct.update({n: 1})
            dct2 = dict(dct)
            if len(dct) == 3:
                for key, val in dct.items():
                    dct2[key] -= 1
                    if dct2[key] == 0:
                        del dct2[key]
            dct = dct2
            # print(dct)
        ans = []
        for key, val in dct.items():
            count = 0
            for n in nums:
                if n == key:
                    count += 1
            if count > len(nums)/3:
                ans.append(key)
        return ans
                    
            
