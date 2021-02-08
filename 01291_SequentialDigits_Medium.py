'''An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
  Example 1:
Input: low = 100, high = 300
Output: [123,234]
Example 2:
Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
  Constraints:
10 <= low <= high <= 10^9''' 
import functools
from typing import List


class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        lst = [int(x) for x in str(low)]
        ans = []
        lst[0] -= 1
        lst = self.digits_up(lst)
        low2 = functools.reduce(lambda total, d: 10 * total + d, lst, 0)
        # print(low,high)
        while low2 <= high:
            if low2 >= low:
                ans.append(low2)
            lst = self.digits_up(lst)
            low2 = functools.reduce(lambda total, d: 10 * total + d, lst, 0)
        return ans

    def digits_up(self, number):
        # print(number)
        number[0] += 1
        if number[0] > 10 - len(number):
            number = [0]*(len(number)+1)
            number[0] += 1
        for i in range(1,len(number)):
            number[i] = number[i-1]+1
        # print(number)
        return number

