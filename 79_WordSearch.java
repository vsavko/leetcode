/*Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.*/

public class WordSearch {
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
    
    private static boolean bfs(char[][] board, String word, int i, int j, int count, boolean arr[][]){
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
