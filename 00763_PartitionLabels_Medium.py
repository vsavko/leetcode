'''A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
  Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
  Note:
S will have length in range [1, 500].
S will consist of lowercase English letters ('a' to 'z') only.
 ''' 
from typing import List


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        map = {}
        for i in range(len(S)):
            map.update({S[i]: i})
        #print(map)
        ans = []
        end = 0
        count = 1
        for i in range(len(S)):
            tmp = map.get(S[i])
            #print(i,tmp,S[i],end)
            if tmp > end:
                end = tmp
            if i == end:
                ans.append(count)
                count = 0
            count += 1
        return ans
                
