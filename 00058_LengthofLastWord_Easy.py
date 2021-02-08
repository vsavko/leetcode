'''Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
A word is a maximal substring consisting of non-space characters only.
  Example 1:
Input: s = "Hello World"
Output: 5
Example 2:
Input: s = " "
Output: 0
  Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.''' 
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        word = 0
        end = len(s)-1
        while end >= 0:
            if s[end] == ' ':
                end -=1
            else: 
                break
        for w in range(end,-1,-1):
            if s[w] == ' ':
                return word
            word += 1
        return word
            
