/*An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
At the end, return the modified image.
Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:
The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].*/ 
class Solution {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int [][] returnImage = image.clone();
        if (image[sr][sc] == newColor) return returnImage;
        Stack<int []> stack = new Stack<>();
        int [] tmp = new int[2];
        tmp[0] = sr;
        tmp[1] = sc;
        stack.add(tmp);
        int oldColor = image[sr][sc];
        //bfs
        while(!stack.isEmpty()) {
            tmp = stack.pop();
            int curRow = tmp[0];
            int curCol = tmp[1];
            //if (image[curRow][curCol] != oldColor) continue;
            //up
            if(curRow> 0 && returnImage[curRow-1][curCol] == oldColor){
                tmp = new int [2];
                tmp[0] = curRow-1;
                tmp[1] = curCol;
                stack.add(tmp);
            }
            //down
            if(curRow < image.length-1 && returnImage[curRow+1][curCol] == oldColor){
                tmp = new int [2];
                tmp[0] = curRow+1;
                tmp[1] = curCol;
                stack.add(tmp);
            }
            //left
            if(curCol > 0 && returnImage[curRow][curCol-1] == oldColor){
                tmp = new int [2];
                tmp[0] = curRow;
                tmp[1] = curCol-1;
                stack.add(tmp);
            }
            //right
            if(curCol < image[0].length-1 && returnImage[curRow][curCol+1] == oldColor){
                tmp = new int [2];
                tmp[0] = curRow;
                tmp[1] = curCol+1;
                stack.add(tmp);
            }
            returnImage[curRow][curCol] = newColor;
        }
        return returnImage;
    }
}
