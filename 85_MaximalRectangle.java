/*Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6*/

import java.util.HashMap;
import java.util.Stack;

public class MaximalRectangle {
	
	 class Rectangle{
		int start_col; //start column
		int start_row; //start row
		int finish_row; //end row

		 Rectangle(int start_col, int start_row, int finish_row) {
			super();
			this.start_col = start_col;
			this.start_row = start_row;
			this.finish_row = finish_row;
		}
	}
	
	private void placeRectangles(char[][] matrix, int i, int jStart, int jEnd, Stack<Rectangle> stack, boolean mode ) {
		
		if (mode && i == 0) return;
		boolean isRectangle = false;
		int start_row=0;
    	for(int j = jStart; j < jEnd; j++) { //iterate rows
    		//System.out.printf("%", matrix[j][i]);
    		//mode true - check previous column too

    		if (isRectangle == false && ((!mode && matrix[j][i] == 1) ||
    				( mode && matrix[j][i] == 1 && matrix[j][i-1] == 1))){ 	

    			start_row = j;
    			isRectangle = true;
    		}

    		//if we reach a 0 zero, or end of col, put a new rectangle into the stack
    		if (!mode) {
	    		if((matrix[j][i] == 0 || j == matrix.length -1) && isRectangle == true) {
	    			if (matrix[j][i] == 0) {
	    				stack.push(new Rectangle(i,start_row,j-1));
	    			}
	    			else {
	    				stack.push(new Rectangle(i,start_row,j));
	    			}
	    			isRectangle = false;
	    		}
    		}
    		else if((matrix[j][i] == 0 || matrix[j][i-1] == 0 || j == jEnd -1) && isRectangle == true) {
	    			
	    			if (matrix[j][i] == 0 || matrix[j][i-1] == 0 ) {
	    				stack.push(new Rectangle(i-1,start_row,j-1));
	    			}
	    			else {
	    				stack.push(new Rectangle(i-1,start_row,j));
	    			}
	    			isRectangle = false;
	    	}
    	}
	}
	
    public int maximalRectangle(char[][] matrix) {
    	HashMap<Integer[], Integer> hm = new HashMap<>();
    	if (matrix == null || matrix.length == 0) return 0;
    	int i = 0,  maxSize = 0;
    	Stack<Rectangle> stack = new Stack<>();
    	Stack<Rectangle> stack2;
    	
        while(i < matrix[0].length) { //cols
        	//check each col for rectangles
        	placeRectangles(matrix,i, 0,matrix.length,stack, false);
        	i++;
        	
        	stack2 = new Stack<>();
            while(!stack.isEmpty()) {
        	//check rectangles from stack on the next col
            	Rectangle tmpRect = stack.pop();
            	
            	int size = (tmpRect.finish_row-tmpRect.start_row+1) *(i-tmpRect.start_col);
            	if (maxSize < size) maxSize = size;
            	
        		//check if remains in the stack
            	if (i < matrix[0].length) {
            		if(checkRect(tmpRect, matrix,i) == true) {
            			stack2.push(tmpRect);
            		}
            		else {//extract other possible rectangles
            			//System.out.println("tee" + tmpRect.start_col + " " + tmpRect.start_row + " " +  tmpRect.finish_row );
            	    	placeRectangles(matrix,i, tmpRect.start_row,tmpRect.finish_row+1,stack, true);
            		}
            	}
            }
            stack = stack2;
        }        
        return maxSize;
    }
    
    public boolean checkRect(Rectangle rect, char[][] matrix, int i) {
    	for(int j = rect.start_row; j <= rect.finish_row; j++) {
			if (matrix[j][i] == 0) return false;
		}
    	return true;
    }
    
    public static void main(String[] args) {
		char [][] arr= {{1,0,1,0,0},
						{1,0,1,1,1},
						{1,1,1,1,1},
						{1,0,0,0,0}};
		
		char [][] arr2 ={{1,1,1,1,1,1,1,1},
						 {1,1,1,1,1,1,1,0},
						 {1,1,1,1,1,1,1,0},
						 {1,1,1,1,1,0,0,0},
						 {0,1,1,1,1,0,0,0}};
		/*char [][] arr= {{1,1,1},
						{1,1,0}};*/
		/*char [][] arr= {{1,0,0},
						{1,1,1},
						{1,1,1}};*/
		System.out.println((new MaximalRectangle()).maximalRectangle(arr));
		System.out.println((new MaximalRectangle()).maximalRectangle(arr2));
	}
}
