/*A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:
The first word in the sequence is beginWord.
The last word in the sequence is endWord.
Only one letter is different between each adjacent pair of words in the sequence.
Every word in the sequence is in wordList.
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
  Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words.
Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no possible transformation.
  Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.*/ 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;

        HashSet<String> visited = new HashSet<>();
        HashSet<String> words = new HashSet<>();
        for(String w: wordList) {
            words.add(w);
        }
        if(!words.contains(endWord)) return 0;
        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        int steps = 2;
        
        while(!stack.isEmpty()) {
        Stack<String> stack2 = new Stack<>();
            while(!stack.isEmpty()) {
                beginWord = stack.pop();
                for(int i = 0; i < beginWord.length(); i++) {
                    for(char j ='a'; j <= 'z'; j++) {
                        String tmp = beginWord.substring(0,i)+j+beginWord.substring(i+1);
                        if(tmp.equals(endWord)) return steps;
                        if(words.contains(tmp) && !visited.contains(tmp) ) {
                            //System.out.println(beginWord);
                            visited.add(tmp);
                            stack2.push(tmp);
                        }
                    }
                }
            }
            ++steps;
            stack = stack2;
        }
        return 0;
        
    }
}
