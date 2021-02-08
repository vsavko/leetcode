/*Implement a trie with insert, search, and startsWith methods.
Example:
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.*/ 

public class Trie {
    private class Node{
        Node[] next = new Node[26];
        boolean end = false;
    }
    Node father;

    /** Initialize your data structure here. */
    public Trie() {
        father = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node tmpNode = father;
        for(int i = 0; i < word.length(); i++){
            char tmpLetter = word.charAt(i);
            if(tmpNode.next[tmpLetter-97] != null) {
                tmpNode = tmpNode.next[tmpLetter-97];
            }
            else {
                tmpNode.next[tmpLetter-97] = new Node();
                tmpNode = tmpNode.next[tmpLetter-97];
            }
            if (i == word.length()-1) tmpNode.end = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node tmpNode = father;
        for(int i = 0; i < word.length(); i++){
            char tmpLetter = word.charAt(i);
            if(tmpNode.next[tmpLetter-97] == null) return false;
            tmpNode = tmpNode.next[tmpLetter-97];
            if (i == word.length()-1 && tmpNode.end == true) return true;
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node tmpNode = father;
        for(int i = 0; i < prefix.length(); i++){
            char tmpLetter = prefix.charAt(i);
            if(tmpNode.next[tmpLetter-97] == null) return false;
            tmpNode = tmpNode.next[tmpLetter-97];
        }
        return true;
    }


    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");   
        System.out.println(trie.search("app"));     // returns true
    }
}

