/*Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
  Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
Example 4:
Input: s = "  Bob    Loves  Alice   "
Output: "Alice Loves Bob"
Example 5:
Input: s = "Alice does not even like bob"
Output: "bob like even not does Alice"
  Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
  Follow up:
Could you solve it in-place with O(1) extra space?
 */ 
class Solution {
    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(s.length());
        boolean start = true, space = false;
        int wordPos = 0;
        for(int i = s.length()-1; i >=0; i--) {
            char ch= s.charAt(i);
            if (start && ch == ' ') continue;
            
            if(ch != ' ') {
                if (space == true) {
                    ans.append(' ');
                    wordPos = ans.length();
                }
                start = false;
                ans.insert(wordPos,ch);
                space = false;
            }
            else {
                space = true;
  
            }
        }
        return ans.toString();
    }
}
