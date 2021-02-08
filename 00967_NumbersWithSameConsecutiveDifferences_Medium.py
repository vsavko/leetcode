'''Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
You may return the answer in any order.
  Example 1:
Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:
Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
Example 3:
Input: n = 2, k = 0
Output: [11,22,33,44,55,66,77,88,99]
Example 4:
Input: n = 2, k = 2
Output: [13,20,24,31,35,42,46,53,57,64,68,75,79,86,97]
  Constraints:
2 <= n <= 9
0 <= k <= 9''' 
from typing import List


class Solution:
    def numsSameConsecDiff(self, N: int, K: int) -> List[int]:
        if N == 0:
            return [0]
        ans = []
        for i in range(1,10):
            tmpList = [i]
            self.recursiveHelper( ans, tmpList, K, N-1)
        ans2 = []
        for l in ans:
            tmp = ""
            for j in l:
                tmp += str(j)
            tmp = int(tmp)
            ans2.append(tmp)
        if N <= 1:
            ans2.insert(0,0)
        return ans2

    def recursiveHelper(self,ans, tmpList, k, N):
        if N == 0:
            ans.append(tmpList.copy())
            return
        if k == 0:
            tmpList.append(tmpList[-1])
            self.recursiveHelper( ans, tmpList, k, N-1)
            tmpList.pop()
        else:
            if tmpList[-1] + k < 10:
                tmpList.append(tmpList[-1] + k)
                self.recursiveHelper( ans, tmpList, k, N-1)
                tmpList.pop()
            if tmpList[-1] - k >= 0:
                tmpList.append(tmpList[-1] - k)
                self.recursiveHelper( ans, tmpList, k, N-1)
                tmpList.pop()

            
