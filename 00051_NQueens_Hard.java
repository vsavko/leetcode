/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
  Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
Example 2:
Input: n = 1
Output: [["Q"]]
  Constraints:
1 <= n <= 9*/ 
class Solution {
    List<List<String>> ans = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        //n by n board
        //n queens
        int [][] availiblePos = new int [n][n];
        //for (int[] row: availiblePos)
        //    Arrays.fill(row, 0);
        //System.out.println(Arrays.deepToString(availiblePos));
        List<String> queens = new ArrayList<>();
        for(int i = 0; i < n; i++ ) {
            queens.add("");
        }
        solve(0, 0, n, availiblePos,queens);
        return ans;
    }
    
    private void solve(int xPos, int yPos, int queensLeft, 
            int [][] availiblePos, List<String> queens) {
        if(queensLeft == 0) {
            //System.out.println(queens);
            ans.add(new ArrayList<String>(queens));
            return;
        }
        int n = availiblePos.length;
        boolean [][] availiblePosCopy = new boolean[n][];
        char [] tmp = new char[n];
        for(int i = 0; i <n; i++) {
            tmp[i] = '.';
        }
        String dotsString = new String(tmp);
        
        for(int y = yPos; y < n; y++) { //rows iteration
            for(int x = 0; x < n; x++) { //cols iteration
                //System.out.println(queensLeft + " x " + x + " y " + y);
                //System.out.println(Arrays.deepToString(availiblePos));
                //System.out.println(queens);
                if(availiblePos[y][x] != 0) {
                    continue; //field allready attacked by a queen
                }
                else {
                    tmp = new char[n];
                    for(int i = 0; i <n; i++) {
                        if(i == x) tmp[i] = 'Q';
                        else tmp[i] = '.';
                    }
                    queens.set(y, new String(tmp));
                    //for(int i = 0; i < availiblePos.length; i++)
                    //  availiblePosCopy[i] = availiblePos[i].clone();

                    //add queen
                    //fill vertical line
                    fillVerical(x,availiblePos,1);
                    //fill hor line
                    fillHorizontal(y,availiblePos,1);
                    //fill 2 diagonal lines
                    fillDiagonal(x,y,availiblePos,1);
                    //System.out.println(Arrays.deepToString(availiblePos));
                    
                    //System.out.println(queens);
                    solve(x, y, queensLeft-1, availiblePos,queens);
                    
                    //delete queen
                    queens.set(y, dotsString);
                    
                    //for(int i = 0; i < availiblePos.length; i++)
                    //  availiblePos[i] = availiblePosCopy[i].clone();
                    
                    //fill vertical line
                    fillVerical(x,availiblePos,-1);
                    //fill hor line
                    fillHorizontal(y,availiblePos,-1);
                    //fill 2 diagonal lines
                    fillDiagonal(x,y,availiblePos,-1);
                    //System.out.println(Arrays.deepToString(availiblePos));

                }
            }
        }
    }
    
    private int [][] fillVerical(int x, int [][] availiblePos, int SetFields){
        for(int z = 0; z < availiblePos.length; z++) {
            availiblePos[z][x] += SetFields;
        }
        return availiblePos;
    }
    
    private int [][] fillHorizontal(int y, int [][] availiblePos, int SetFields){
        for(int z = 0; z < availiblePos.length; z++) {
            availiblePos[y][z] += SetFields;
        }
        return availiblePos;
    }
    
    private int [][] fillDiagonal(int x, int y, int [][] availiblePos, int SetFields){
        int c1 = y - x, c2 = y + x;
        for(int z = 0; z < availiblePos.length; z++) {
            if(c1 + z > 0 && c1 + z < availiblePos.length)
                availiblePos[c1 + z][z] += SetFields;
            if(c2 - z > 0 && c2 - z < availiblePos.length)
                availiblePos[c2 - z][z] += SetFields;
        }
        return availiblePos;
    }
}
