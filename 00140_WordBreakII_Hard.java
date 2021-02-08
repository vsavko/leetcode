/*Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.
Note:
The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:
Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:
Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:
Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]*/ 
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String> >());
    }
    
    private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> 
        set ){
        if(s.length() == 0) return null;
        if(set.containsKey(s)) return set.get(s);
        
        List<String> list = new LinkedList<>();
        
        for(String word: wordDict){
            List<String> tmpList = new LinkedList<>();
            if (s.startsWith(word)){
               tmpList = dfs(s.substring(word.length()), wordDict,set);
            }
            
            if (tmpList != null) {
                for(String str : tmpList) {
                    list.add(word + " " + str);
                }
            }
            else
                list.add(word);
        }
        set.put(s,list);
        return list;
    }
    

}
