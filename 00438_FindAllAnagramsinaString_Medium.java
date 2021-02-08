/*Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.
Example 1:
Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:
Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".*/ 
class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        //form hash table from string p
        Map<Character, Integer> hm = new HashMap<>();
        for(int i = 0 ; i < p.length(); i++) {
            if (!hm.containsKey(p.charAt(i))) {
                hm.put(p.charAt(i), 1);
            }
            else {
                hm.put(p.charAt(i), hm.get(p.charAt(i)) +1);
            }
        }
        int matches = 0;
        for (int i  = 0; i < s.length(); i++) {
            
            char character = s.charAt(i);
            if(hm.containsKey(character)) {
                hm.put(character, hm.get(character) - 1);
                if (hm.get(character) == 0) {
                    ++matches;
                }
            }
            
            if (i >= p.length()) {
                character = s.charAt(i - p.length());
                if (hm.containsKey(character)) {
                    hm.put(character, hm.get(character) + 1);
                    if (hm.get(character) == 1) {
                        --matches;
                    }
                }
            }
            
            if (matches == hm.size()) {
                ans.add(i - p.length() + 1);
            }

        }

        return ans;
        
    }
}
