/*Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.
  Example 1:
Input: s = "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
Example 2:
Input: s = "a"
Output: 0
Example 3:
Input: s = "ab"
Output: 1
  Constraints:
1 <= s.length <= 2000
s consists of lower-case English letters only.*/ 
class Solution {
      public int minCut(String s) {
        int []dp = new int [s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s,0,i))
                dp[i] = 0;
            else {
                int partMin = Integer.MAX_VALUE;
                for(int j = i; j >0; j--) {
                    if(isPalindrome(s,j,i)) {
                        partMin = Math.min(partMin, dp[j-1] +1);
                    }
                    dp[i] = partMin;
                }
            }
        }
        return dp[s.length()-1];
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
