/*Given a word, you need to judge whether the usage of capitals in it is right or not.
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
  Example 1:
Input: "USA"
Output: True
  Example 2:
Input: "FlaG"
Output: False
  Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.*/ 
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;
        boolean AllCapital = false;
        
        if (word.charAt(1) >= 'A' &&  word.charAt(1) <= 'Z')
            AllCapital = true;
        
        if (AllCapital && word.charAt(0) >= 'a' &&  word.charAt(0) <= 'z')
            return false;
        
        for (int i = 1; i < word.length(); i++){
            if (word.charAt(i) >= 'A' &&  word.charAt(i) <= 'Z') {
                if (AllCapital == false)
                    return false;
            }
            if (word.charAt(i) >= 'a' &&  word.charAt(i) <= 'z' && AllCapital == true) {
                return false;
            }

        }
        return true;
    }
}
