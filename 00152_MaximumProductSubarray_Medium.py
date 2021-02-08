'''Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.''' 
from typing import List
from copy import deepcopy


class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        #split by 0
        #if even negatives multiply all
        #if odd take multiplies till last and till first and compare
        maxProduct = nums[0]
        nozero = []
        tmp = []
        for num in nums:
            if num != 0:
                tmp.append(num)
            else:
                if maxProduct < 0:
                    maxProduct = 0
                if len(tmp) > 0:
                    nozero.append(deepcopy(tmp))
                tmp = []
        if len(tmp) > 0:
            nozero.append(deepcopy(tmp))
        # print(nozero)
        for lst in nozero:
            countNegative = 0
            for num in lst:
                if num < 0:
                    countNegative += 1
            if countNegative % 2 == 0:
                tmp = 1
                for num in lst:
                    tmp *= num
                if tmp > maxProduct:
                    maxProduct = tmp
            else:
                #first negative
                first = 0
                for i in range(len(lst)):
                    if lst[i] < 0:
                        first = i
                        break
                tmp = 1
                if len(lst) - first - 1 == 0:
                    tmp = lst[first]
                # print("first",first)
                for i in range(first+1, len(lst)):
                    # print("num",num)
                    tmp *= lst[i]
                if tmp > maxProduct:
                    maxProduct = tmp
                # print("tmp", tmp)
                #last negative
                last = 0
                for i in range(len(lst)-1,-1,-1):
                    # print(lst)
                    # print("i",i,"nums",lst[i],len(lst))
                    if lst[i] < 0:
                        last = i
                        break
                tmp = 1
                if last == 0:
                    tmp = lst[0]
                # print("last",last)
                for i in range(0, last):
                    tmp *= lst[i]
                if tmp > maxProduct:
                    maxProduct = tmp
        return maxProduct
