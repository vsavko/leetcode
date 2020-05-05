import java.util.Arrays;
import java.util.Stack;

public class TrappingRainWater {
	private class Wall{
		public int bottom, top, position;

		public Wall(int bottom, int top, int position) {
			super();
			this.bottom = bottom;
			this.top = top;
			this.position = position;
		}
		
		   @Override
		    public String toString() { 
		        return String.format(bottom + " " + top + " " + position); 
		    } 
		
	}
	
    public int trap(int[] height) {
        Stack<Wall> stack = new Stack<>();
        int solution = 0;
        for(int i = 0; i < height.length; i++) {
        	if (height[i] != 0) {
    			while (!stack.isEmpty() && stack.peek().top <= height[i]) {
    				Wall tmpWall = stack.pop();
    				solution += (i - tmpWall.position - 1) *
    						(tmpWall.top - tmpWall.bottom);
    			}
    			if (!stack.isEmpty() && stack.lastElement().bottom < height[i]) { //
    				solution += (i - stack.lastElement().position - 1) *
    						(height[i] - stack.lastElement().bottom);
    				stack.lastElement().bottom = height[i];
    			}
        		stack.add(new Wall(0, height[i], i));	
        	}
        	//stack.forEach(System.out::println);
        	//System.out.println(i + " solution "  + solution);
        }
        return solution;
    }
    
    public static void main(String[] args) {
    	int [] arr = {4,2,3};
    	TrappingRainWater solution = new TrappingRainWater();
    	System.out.println(solution.trap(arr));
	}
}
