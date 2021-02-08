'''Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
  Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"
Output: False
Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)''' 
class Solution:
    def repeatedSubstringPattern(self, s: str) -> bool:
        rem = 1
        while (rem <= len(s)/2):
            if len(s) % rem == 0:
                lst = s[:rem+1]
                isPattern = True
                for i in range(len(s)):
                    if lst[i%rem] != s[i]:
                        isPattern = False
                        break
                if isPattern:
                    return True
            rem += 1
        return False
                        
