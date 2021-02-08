/*We can scramble a string s to get a string t using the following algorithm:
If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.
  Example 1:
Input: s1 = "great", s2 = "rgeat"
Output: true
Explanation: One possible scenario applied on s1 is:
"great" --> "gr/eat" // divide at random index.
"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
"gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each of them.
"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
The algorithm stops now and the result string is "rgeat" which is s2.
As there is one possible scenario that led s1 to be scrambled to s2, we return true.
Example 2:
Input: s1 = "abcde", s2 = "caebd"
Output: false
Example 3:
Input: s1 = "a", s2 = "a"
Output: true
  Constraints:
s1.length == s2.length
1 <= s1.length <= 30
s1 and s2 consist of lower-case English letters.*/ 
class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0 && s2.length() == 0) return true;
        boolean [][][] dp = new boolean[s1.length()][s2.length()][s1.length()+1];
        //length of substring, from 1 char to total length
        for(int len = 1; len <= s1.length(); len++) {
            //position of the substring in string1
            for(int s1Ptr = 0; s1Ptr + len <= s1.length(); s1Ptr++) {
                //position of the substring in string2
                for (int s2Ptr = 0; s2Ptr + len <= s2.length(); s2Ptr++) { 
                    
                    if (len == 1) {
                        if(s1.charAt(s1Ptr) == s2.charAt(s2Ptr)) 
                            dp[s1Ptr][s2Ptr][1] = true;
                    }
                    else {
                        for(int i = 1; i < len; i++) {
                            if(dp[s1Ptr][s2Ptr][i] && dp[s1Ptr+i][s2Ptr+i][len-i] ||
                                    dp[s1Ptr][s2Ptr + len - i][i] && dp[s1Ptr + i][s2Ptr][len
                                        -i] ) {
                                dp[s1Ptr][s2Ptr][len] = true;
                            }
                        }
                    }
                    
                }
                
            }
        }
        return dp[0][0][s1.length()];
    }
}
