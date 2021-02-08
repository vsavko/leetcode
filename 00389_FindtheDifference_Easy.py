'''You are given two strings s and t.
String t is generated by random shuffling string s and then add one more letter at a random position.
Return the letter that was added to t.
  Example 1:
Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.
Example 2:
Input: s = "", t = "y"
Output: "y"
Example 3:
Input: s = "a", t = "aa"
Output: "a"
Example 4:
Input: s = "ae", t = "aea"
Output: "a"
  Constraints:
0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lower-case English letters.''' 
class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        dct = {}
        for char in s:
            if char not in dct:
                dct[char] = 0
            dct[char] += 1
        for char in t:
            if char not in dct:
                return char
            dct[char] -= 1
            if dct[char] < 0:
                return char
