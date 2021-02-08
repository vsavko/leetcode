/*Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where: 
'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).
  Example 1:
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:
Input: s = "aab", p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
Example 5:
Input: s = "mississippi", p = "mis*is*p*."
Output: false
  Constraints:
0 <= s.length <= 20
0 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.*/ 
class Solution {
    public static boolean isMatch(String searchedStr, String regex) {

        return recursiveRegex2(0,0,searchedStr, regex);
    }
    
    private static boolean recursiveRegex2 (int regexPos, int stringPos, String searchedStr, 
        String regex) {
        int regexRemLen = regex.length() - regexPos -1, stringRemLen = searchedStr.length() - 
            stringPos - 1;
        
        if( stringRemLen < 0 && (regexRemLen < 0 || (regexRemLen == 1 && regex.charAt(regexPos
            +1) == '*')))
                return true;
        
        if( regexRemLen >= 0 && stringRemLen >= 0) {
            if (regexRemLen  > 0 && regex.charAt(regexPos + 1) == '*') {
                if (regex.charAt(regexPos) == searchedStr.charAt(stringPos) || regex.charAt
                    (regexPos) == '.' ) //use kleene star character
                    if (recursiveRegex2(regexPos, stringPos+1, searchedStr, regex)) return 
                        true;
                if (regexRemLen > 1 && recursiveRegex2(regexPos+2, stringPos, searchedStr, 
                    regex)) return true; //skip kleene star character
            }
            else { //if no kleene star 
                if((regex.charAt(regexPos) == searchedStr.charAt(stringPos) || regex.charAt
                    (regexPos) == '.')) 
                    if(recursiveRegex2 (regexPos+1, stringPos+1, searchedStr, regex)) return 
                        true;
            }
        }
        
        if (regexRemLen > 0 && stringRemLen < 0 && regex.charAt(regexPos + 1) == '*') {
            if (regexRemLen > 1 && recursiveRegex2(regexPos+2, stringPos, searchedStr, regex)) 
                return true;
        }

        return false;
    }
}
