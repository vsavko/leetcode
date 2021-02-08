/*Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
  Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
  Constraints:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].*/ 
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0 ; i <s1.length(); i++) {
            if (!hm.containsKey(s1.charAt(i))) {
                hm.put(s1.charAt(i), 1);
            }
            else {
                hm.put(s1.charAt(i), hm.get(s1.charAt(i)) +1);
            }
        }
        int matches = 0;
        for (int i  = 0; i < s2.length(); i++) {
            
            char character = s2.charAt(i);
            if(hm.containsKey(character)) {
                hm.put(character, hm.get(character) - 1);
                if (hm.get(character) == 0) {
                    ++matches;
                }
            }
            
            if (i >= s1.length()) {
                character = s2.charAt(i - s1.length());
                if (hm.containsKey(character)) {
                    hm.put(character, hm.get(character) + 1);
                    if (hm.get(character) == 1) {
                        --matches;
                    }
                }
            }
            
            if (matches == hm.size()) {
                return true;
            }

        }

        return false;
    }
}

