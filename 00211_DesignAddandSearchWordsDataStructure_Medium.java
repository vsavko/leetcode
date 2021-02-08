/*Design a data structure that supports adding new words and finding if a string matches any previously added string.
Implement the WordDictionary class:
WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
  Example:
Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
  Constraints:
1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.*/ 
class WordDictionary {
    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;
        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }
     
    }
     
    public class Trie {
        private TrieNode root;
        HashSet<TrieNode> possibleWords;
     
        public Trie() {
            root = new TrieNode();
        }
     
        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode p = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                int index = c-'a';
                if(p.arr[index]==null){
                    TrieNode temp = new TrieNode();
                    p.arr[index]=temp;
                    p = temp;
                }else{
                    p=p.arr[index];
                }
            }
            p.isEnd=true;
        }
     
        // Returns if the word is in the trie.
        public boolean search(String s){
            possibleWords = new HashSet<>();
            possibleWords.add(root);
            
            for(int i = 0; i < s.length(); i++){
                char c= s.charAt(i);

                HashSet<TrieNode> tmpPossWords= new HashSet<>();
                
                if (c == '.') { //wildcard matching
                    for(TrieNode key : possibleWords) {
                        for(int j = 0; j < key.arr.length; j++) {
                            if(key.arr[j] != null)
                                tmpPossWords.add(key.arr[j]);
                        }
                    }
                }
                else {
                    for(TrieNode key : possibleWords) {
                        int index = c-'a';
                        if(key.arr[index]!=null){
                            tmpPossWords.add(key.arr[index]);
                        }
                    }
                }
                
                if(tmpPossWords.size() == 0) return false;
                
                possibleWords = new HashSet<>(tmpPossWords);
            }
            
            for(TrieNode key :possibleWords) {
                if (key.isEnd) return true;
            }
            
            return false;
        }
    }
    
    Trie dictionary;

    /** Initialize your data structure here. */
    public WordDictionary() {
        dictionary = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        dictionary.insert(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character 
        '.' to represent any one letter. */
    public boolean search(String word) {
        return dictionary.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
