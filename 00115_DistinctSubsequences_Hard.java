/*Given two strings s and t, return the number of distinct subsequences of s which equals t.
A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
It's guaranteed the answer fits on a 32-bit signed integer.
  Example 1:
Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:
Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag
  Constraints:
0 <= s.length, t.length <= 1000
s and t consist of English letters.*/ 
class Solution {
    public static int numDistinct(String s, String t) {
        if (t.length() == 0 ) return 1;
        if (s.length() == 0) return 0;
        int [][] dp = new int [t.length()][s.length()];
        for(int i = 0; i < t. length(); i++){
            int count = 0;
            for(int j = i; j < s.length(); j++){
                if (i == 0){
                    if (s.charAt(j) == t.charAt(i) ) 
                        ++count;
                }
                else {
                    if(s.charAt(j) == t.charAt(i) && dp[i-1][j-1] > 0)
                        count = dp[i-1][j-1]+count;
                }
                dp[i][j] = count;
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return dp[t.length()-1][s.length()-1];
    }
    
}
