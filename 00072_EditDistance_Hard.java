/*Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
You have the following three operations permitted on a word:
Insert a character
Delete a character
Replace a character
  Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
  Constraints:
0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.*/ 
class Solution {
   public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        
        int [][] dp = new int[word1.length()+1][word2.length()+1];
        //word1  - rows, word2 - cols
        for(int y = 0; y <= word1.length(); y++ ) {
            dp[y][0] = y;
        }
        
        for(int x = 0; x <= word2.length(); x++ ) {
            dp[0][x] = x;
        }
        
        for(int y = 1; y <= word1.length(); y++) {//rows
            for(int x = 1; x <=  word2.length(); x++) {//cols
                int delete = dp[y][x-1] +1;
                int insert = dp[y-1][x] + 1;
                int replace;
                if (word1.charAt(y-1) == word2.charAt(x-1)) 
                    replace = dp[y-1][x-1] + 0;
                else
                    replace = dp[y-1][x-1] + 1;
                dp[y][x] = Math.min(Math.min(delete, insert),replace);
            }
        }
        
        /*for(int y = 0; y <= word1.length(); y++) {//rows
            for(int x = 0; x <=  word2.length(); x++) {//cols
                System.out.print(dp[y][x] + " ");   
            }
            System.out.println();   
        }*/

        return dp[word1.length()][word2.length()];
    }
}
