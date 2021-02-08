'''Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
  Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
Example 4:
Input: pattern = "abba", s = "dog dog dog dog"
Output: false
  Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lower-case English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.''' 
class Solution:
    def wordPattern(self, pattern, str) -> bool:
        st = set()
        dct = {}
        lst = str.split()
        if len(lst) != len(pattern):
            return False
        for i in range(len(pattern)):
            if dct.__contains__(pattern[i]):
                if dct.get(pattern[i]) != lst[i]:
                    return False
            else:
                if not st.__contains__(lst[i]):
                    st.add(lst[i])
                else:
                    return False
                dct.update({pattern[i]:lst[i]})
        return True
