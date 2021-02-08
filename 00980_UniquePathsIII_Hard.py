'''On a 2-dimensional grid, there are 4 types of squares:
1 represents the starting square.  There is exactly one starting square.
2 represents the ending square.  There is exactly one ending square.
0 represents empty squares we can walk over.
-1 represents obstacles that we cannot walk over.
Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
  Example 1:
Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
Example 2:
Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
Example 3:
Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.
  Note:
1 <= grid.length * grid[0].length <= 20''' 
from typing import List


class Solution:
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        # find starting point
        start_x, start_y, number_to_wlk_over = 0, 0, 0
        # print("y:",len(grid), "x:", len(grid[0]))
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] == 1:
                    start_y = i
                    start_x = j
                elif grid[i][j] != -1:
                    number_to_wlk_over += 1
        # print(start_x,start_y)

        return self.dfs(grid, number_to_wlk_over, start_y, start_x, [])


    def dfs(self, grid, number_to_wlk_over, y, x, path):
        if grid[y][x] == 2 and number_to_wlk_over == 0:
            # path.append([y, x])
            # print(path)
            # path.pop()
            return 1
        elif grid[y][x] == 2 or number_to_wlk_over == 0:
            return 0
        ans = 0
        tmp = grid[y][x]
        grid[y][x] = -1
        # path.append([y,x])
        # print("x,y",x,y)
        # if can go up
        if y > 0 and (grid[y-1][x] == 0 or grid[y-1][x] == 2):
            ans += self.dfs(grid, number_to_wlk_over-1, y-1, x, path)
        # right
        if x < len(grid[y])-1 and (grid[y][x+1] == 0 or grid[y][x+1] == 2):
            ans += self.dfs(grid, number_to_wlk_over - 1, y, x +1, path)
        #down
        if y < len(grid)-1 and (grid[y+1][x] == 0 or grid[y+1][x] == 2):
            ans += self.dfs(grid, number_to_wlk_over - 1, y + 1, x, path)
        #left
        if x > 0  and (grid[y][x-1] == 0 or grid[y][x-1] == 2):
            ans += self.dfs(grid, number_to_wlk_over - 1, y, x - 1, path)
        grid[y][x] = tmp
        # path.pop()
        return ans

