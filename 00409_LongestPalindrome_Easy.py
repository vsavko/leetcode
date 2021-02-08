'''Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
  Example 1:
Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:
Input: s = "a"
Output: 1
Example 3:
Input: s = "bb"
Output: 2
  Constraints:
1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.''' 
class Solution:
    def longestPalindrome(self, s: str) -> int:
        dict = {}
        for char in s:
            if char in dict:
                dict[char] += 1
            else:
                dict[char] = 1
        values = dict.values()
        ans = 0
        addOne = False
        for val in values:
            if val % 2 == 1:
                addOne = True
            ans += (val // 2) * 2
        if addOne == True:
            ans += 1
        #for key, value in dict.items():
        #    print(key, " ", value)
        return ans
