/*Given an array of string words. Return all strings in words which is substring of another word in any order. 
String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].
  Example 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
Example 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".
Example 3:
Input: words = ["blue","green","bu"]
Output: []
  Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 30
words[i] contains only lowercase English letters.
It's guaranteed that words[i] will be unique.*/ 
class Solution {
    public static List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();// comparision
            }
        });

        int lengthLevel = 0, pos = 0;
        for(int i = 0; i < words.length; i++) {
            if (words.length > lengthLevel) {
                lengthLevel = words.length;
                pos = i;
            }
            for(int j = pos; j < words.length; j++) {
                if(j == i) continue;
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                } 
            }
        }
        return ans;
    }
}
