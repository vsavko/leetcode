package test;

import java.util.Stack;

public class MaximalRectangle {
	
	public class Rectangle{
		int size;
		int start_col; //start column
		int start_row; //start row
		int finish_row; //end row
		
		public Rectangle(int size, int start_col, int start_row, int finish_row) {
			super();
			this.size = size;
			this.start_col = start_col;
			this.start_row = start_row;
			this.finish_row = finish_row;
		}
	}
	
    public int maximalRectangle(char[][] matrix) {
    	int i = 0, start_row=0, maxSize = 0;
    	Stack<Rectangle> stack = new Stack<>();
    	boolean isRectangle = false;
    	boolean [] colCheck = new boolean[matrix.length];	
    	Stack<Rectangle> stack2;
    	
        while(i < matrix[0].length) { //cols
        	//check each col for rectangles
        	for(int j = 0; j < matrix.length; j++) { //iterate rows
        		if(colCheck[j] == true) continue; //if row allready has a rectangle
        		
        		if (isRectangle == false && matrix[j][i] == 1) {
        			start_row = j;
        			isRectangle = true;
        		}
        		
        		//if we reach a 0 zero, or end of col, put a new rectangle into the stack
        		if((matrix[j][i] == 0 || j == matrix.length -1) && isRectangle == true) {
        			stack.push(new Rectangle(j-start_row,i,start_row,j-1));
        			isRectangle = false;
        		}
        	}
        	i++;
        	
        	stack2 = new Stack<>();
            while(!stack.isEmpty()) {
        	//check rectangles from stack on the next col
        		colCheck = new boolean[matrix.length];	 //temp col to store values of existing rectangles
            	Rectangle tmpRect = stack.pop();
            	if (maxSize < tmpRect.size) maxSize = tmpRect.size;
            	
        		//check if remains in the stack
            	if (i < matrix[0].length) {
            		if(checkRect(tmpRect, matrix,i) == true) {
            			tmpRect.size += (tmpRect.finish_row - tmpRect.start_row + 1);
            			stack2.push(tmpRect);
            			for(int j = tmpRect.start_row; j <= tmpRect.finish_row; j++) {
            				colCheck[j] = true;
            			}
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
		/*char [][] arr= {{1,0,1,0,0},
						{1,0,1,1,1},
						{1,1,1,1,1},
						{1,0,0,1,0}};*/
		char [][] arr= {{1,0,0},
						{1,0,0}};

		System.out.println((new MaximalRectangle()).maximalRectangle(arr));
	}
}
