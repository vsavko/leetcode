/*Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
  Example 1:
Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:
Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
  Constraints:
1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 105*/ 
class Solution {
            public static int longestSubstring(String s, int k) {
        if(s.length() < k) return 0;
        int [] alphabet = new int[26];
        int max = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            ++alphabet[s.charAt(i) - 'a'];
        }
        boolean isCompelte = true;
        for(int i = 0; i < 26; i++) {
            if (alphabet[i] < k && alphabet[i] > 0) isCompelte = false;
        }
        if(isCompelte) return s.length();

        boolean isWhole = true;
        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if(alphabet[s.charAt(i)-'a'] < k ) {
                ans = longestSubstring(s.substring(j, i),k);
                j = i+1;
            }
            else if (i == s.length()-1) {
                ans = longestSubstring(s.substring(j, i+1),k);
            }
            if(ans > max) max = ans;
            
        }
        
        return max;
    }
}
