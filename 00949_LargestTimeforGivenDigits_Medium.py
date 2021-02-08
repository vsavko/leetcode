'''Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.
24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
Return the latest 24-hour time in "HH:MM" format.  If no valid time can be made, return an empty string.
  Example 1:
Input: A = [1,2,3,4]
Output: "23:41"
Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", "23:14", and "23:41". Of these times, "23:41" is the latest.
Example 2:
Input: A = [5,5,5,5]
Output: ""
Explanation: There are no valid 24-hour times as "55:55" is not valid.
Example 3:
Input: A = [0,0,0,0]
Output: "00:00"
Example 4:
Input: A = [0,0,1,0]
Output: "10:00"
  Constraints:
arr.length == 4
0 <= arr[i] <= 9''' 
import copy
from typing import List


class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:
        h1list = copy.deepcopy([x for x in A if 0 <= x <= 2])
        while len(h1list) > 0:
            h1 = max(h1list)
            h1list.remove(h1)
            ans = str((h1))
            A.remove((h1))
            if (h1) == 2:
                h2list = copy.deepcopy([x for x in A if 0 <= x <= 3])
            else:
                h2list = copy.deepcopy(A)
            while(len(h2list) > 0):
                h2 = max(h2list)
                ans += str(h2)
                ans += ':'
                A.remove(h2)
                h2list.remove(h2)
                h3list = [x for x in A if 0 <= x <= 5]
                if(len(h3list) > 0):
                    ans += str(max(h3list))
                    A.remove(max(h3list))
                    ans += str(A[0])
                    return ans
                ans[1:]
                A.append(h2)
            A.append(h1)
        return ""
