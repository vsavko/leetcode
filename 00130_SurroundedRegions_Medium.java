/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
Example:
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:
X X X X
X X X X
X X X X
X O X X
Explanation:
Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.*/ 
class Solution {
    public void solve(char[][] board) {
        if(board.length == 0  || board[0].length == 0) return;
        
        //dfs
        for(int i = 0; i < board[0].length; i++){
           //top 
            if(board[0][i] == 'O') recursiveHelper(board, 0, i);
           //bottom
            if(board[board.length-1][i] == 'O') recursiveHelper(board, board.length-1, i);

        }
 
        for(int i = 0; i < board.length; i++){
            //left
            if(board[i][0] == 'O') recursiveHelper(board, i, 0);
           //right
            if(board[i][board[0].length-1] == 'O') recursiveHelper(board, i, board[0].length-1
                );
        }
                                                                           
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'C') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    
    private void recursiveHelper (char[][] board, int row, int col){
        //System.out.println(Arrays.deepToString(board));
        if(board[row][col] != 'O') return;
        board[row][col] = 'C';
        
        //top
        if (row-1 >= 0 && col > 0 && col < board[0].length-1)
        recursiveHelper(board, row-1, col);
            
        //bottom
        if (row +1 < board.length && col > 0 && col < board[0].length-1)
        recursiveHelper(board, row+1, col);
        
        //left
        if (col -1 >= 0 && row > 0 && row < board.length-1)
        recursiveHelper( board, row, col-1);
        
        //right
        if (col +1 < board[0].length  && row > 0 && row < board.length-1)
        recursiveHelper(board, row, col+1);
        
    }
}
