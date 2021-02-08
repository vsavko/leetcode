/*Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
  Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
  Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.*/ 
class Solution {
        class TrieNode {
        TrieNode[] arr;
        boolean isEnd = false;
        // Initialize your data structure here.
        public TrieNode() {
            this.arr = new TrieNode[26];
        }
     
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        //make a trie from words array
        TrieNode trie = new TrieNode();
        trie.isEnd = false;
        for(int i = 0; i < words.length; i++) {
            TrieNode tmpTrie = trie;
            for(int j = 0; j < words[i].length(); j++) {
                if(tmpTrie.arr[words[i].charAt(j) - 'a'] == null)
                    tmpTrie.arr[words[i].charAt(j) - 'a'] = new TrieNode();
                tmpTrie = tmpTrie.arr[words[i].charAt(j) - 'a'];
                if(j == words[i].length() -1)
                    tmpTrie.isEnd = true;
            }
        }
        
        List<String> ans = new LinkedList<>();
        TrieNode tmpTrie;
        //use dfs, check with prefix trie
        boolean [][] possible = new boolean[board.length][board[0].length];
        StringBuilder tmpString = new StringBuilder();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                possible[i][j] = true;
                tmpString.append(board[i][j]);
                tmpTrie = trie.arr[board[i][j] - 'a'];
                dfs(ans,tmpTrie,possible,board,tmpString,i,j);
                tmpTrie = trie;
                possible[i][j] = false;
                tmpString.deleteCharAt(tmpString.length()-1);
                }
        }
        
        return ans;
    }
    
    private void dfs(List<String> ans, TrieNode trie, boolean [][] possible, char[][] board, 
        StringBuilder tmpString,int row, int col) {
        //System.out.println(tmpString);
        //if(tmpString.toString().startsWith("aaa"))
        //  System.out.println(Arrays.deepToString(possible));
        if(trie == null) return;
        if(trie.isEnd ) {
            //System.out.println(tmpString);
            if(!ans.contains(tmpString.toString()))
                ans.add(new String(tmpString));
        }
        //System.out.println(tmpString);
        TrieNode tmpTrie = trie;
        //check up
        if(row > 0 && possible[row-1][col] == false) {
            possible[row-1][col] = true;
            tmpString.append(board[row-1][col]);
            tmpTrie = trie.arr[board[row-1][col] - 'a'];
            dfs(ans,tmpTrie,possible,board,tmpString,row-1,col);
            tmpTrie = trie;
            possible[row-1][col] = false;
            tmpString.deleteCharAt(tmpString.length()-1);
        }
        //check bottom
        if(row < board.length -1 && possible[row+1][col] == false) {
            possible[row+1][col] = true;
            tmpString.append(board[row+1][col]);
            tmpTrie = trie.arr[board[row+1][col] - 'a'];
            dfs(ans,tmpTrie,possible,board,tmpString,row+1,col);
            tmpTrie = trie;
            possible[row+1][col] = false;
            tmpString.deleteCharAt(tmpString.length()-1);
        }
        //check left
        if(col > 0 && possible[row][col-1] == false) {
            possible[row][col-1] = true;
            tmpString.append(board[row][col-1]);
            tmpTrie = trie.arr[board[row][col-1] - 'a'];
            dfs(ans,tmpTrie,possible,board,tmpString,row,col-1);
            tmpTrie = trie;
            possible[row][col-1] = false;
            tmpString.deleteCharAt(tmpString.length()-1);
        }
        //check right
        if(col < board[0].length -1 && possible[row][col+1] == false) {
            possible[row][col+1] = true;
            tmpString.append(board[row][col+1]);
            tmpTrie = trie.arr[board[row][col+1] - 'a'];
            dfs(ans,tmpTrie,possible,board,tmpString,row,col+1);
            tmpTrie = trie;
            possible[row][col+1] = false;
            tmpString.deleteCharAt(tmpString.length()-1);
        }
        
    }
    
}
