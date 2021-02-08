/*Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
  Example 1:
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:
Input: s = ""
Output: 0
  Constraints:
0 <= s.length <= 3 * 104
s[i] is '(', or ')'.*/ 
class Solution {
 public static int longestValidParentheses(String s) {
        int leftOpenBracket  = 0;
        int currentChar = 0, maxSequence = -1;
        Stack<Integer> bracketArray = new Stack<>();
        
        while(currentChar < s.length()) {
            if (s.charAt(currentChar) == '(') {
                bracketArray.push(currentChar);
                ++leftOpenBracket;
            }
            if (s.charAt(currentChar) == ')') {
                if (leftOpenBracket > 0) {
                bracketArray.pop();
                --leftOpenBracket;
                }
                else {
                    bracketArray.push(currentChar);
                }
            }
            
            ++currentChar;
        }
        bracketArray.push(currentChar);
        int prevKey = -1;
        for(int key: bracketArray) {
            maxSequence = Math.max(maxSequence, key - prevKey - 1);
            prevKey = key;
        }

        return maxSequence;
     }
}
