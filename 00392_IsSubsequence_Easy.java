/*Given two strings s and t, check if s is a subsequence of t.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
  Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false
  Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
  Follow up: If there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?*/ 
class Solution {
    public static boolean isSubsequence(String s, String t) {
        int i = 0, z = -1;
        while(i < s.length() && z < t.length()-1) {
            char c = s.charAt(i);
            while(z < (t.length() -1) && t.charAt(++z) != c);
            if(c == t.charAt(z)) ++i;
            //System.out.println(z + " " +i);
        }
        if (i != s.length()) return false;
        else return true;
    }
}
