/*Given a string s, return the longest palindromic substring in s.
  Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:
Input: s = "cbbd"
Output: "bb"
Example 3:
Input: s = "a"
Output: "a"
Example 4:
Input: s = "ac"
Output: "a"
  Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),*/ 
class Solution {
    public String longestPalindrome(String s) {
        boolean [][] dp = new boolean [s.length()][s.length()];
        int maxAns = 0;
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            int tmpAns = 0;
            for(int j = 0; j < s.length() - i ; j++){
                if(i == 0) {
                    dp[j][j] = true;
                    tmpAns = 1;
                }
                else if(i == 1) {
                    if (s.charAt(j) ==  s.charAt(j+i)){
                        dp[j][j+i] = true;
                        tmpAns = 2;
                    }
                }
                else {
                    if (s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1] == true){
                        dp[j][j+i] = true;
                        tmpAns = i+1;
                    }
                        
                }
                if (tmpAns > maxAns) {
                    maxAns = tmpAns;
                    ans = s.substring(j,j+i+1);
                    //System.out.println(maxAns + ans + " j " + j + " i " + i);
                }        
            }
            
        }
       //System.out.println(Arrays.deepToString(dp));
        return ans;
    }
                      
}
