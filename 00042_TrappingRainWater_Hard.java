/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
  Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
  Constraints:
n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105*/ 
class Solution {
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
}
