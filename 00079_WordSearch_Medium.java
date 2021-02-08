/*Given an m x n board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
  Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
  Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 200
1 <= word.length <= 103
board and word consists only of lowercase and uppercase English letters.*/ 
class Solution {
       public static boolean exist(char[][] board, String word) {
        //use bfs search
        boolean [][] arr = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j =0; j < board[i].length; j++){
                if (bfs(board, word, i, j, 1, arr) == true) return true;
            }
        }
        return false;
    }
    
    private static boolean bfs(char[][] board, String word, int i, int j, int count, boolean 
        arr[][]){
        if(word.charAt(count-1) != board[i][j]) return false;
        if(count == word.length()) return true;

        arr[i][j] = true;
        
        //check top
        if(i>0 && arr[i-1][j] == false){
            if (bfs(board, word, i-1, j, count + 1, arr) == true) return true;
        }
        //check left
        if(j>0 && arr[i][j-1] == false){
            if (bfs(board, word, i, j-1, count + 1, arr) == true) return true;  
        }
        //check right
        if(j<board[i].length-1 && arr[i][j+1] == false){
            if (bfs(board, word, i, j+1, count + 1, arr) == true) return true;   
        }
        //check bottom
        if(i<board.length-1 && arr[i+1][j] == false){
            if (bfs(board, word, i+1, j, count + 1, arr) == true) return true;  
        }
    
        arr[i][j] = false;
        return false;
    }
}
