'''Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.
  Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
  Constraints:
Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].''' 
class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        lst1 = []
        self.dfs(root1, lst1)
        lst2 = []
        self.dfs(root2, lst2)
        i, j = 0, 0
        ans = []

        while i < len(lst1) or j < len(lst2):
            if i < len(lst1) and (j == len(lst2) or lst1[i] <= lst2[j]):
                ans.append(lst1[i])
                i += 1
            if j < len(lst2) and (i == len(lst1) or lst1[i] > lst2[j]):
                ans.append(lst2[j])
                j += 1
        return ans

    def dfs(self, root, lst):
        if root is None:
            return
        self.dfs(root.left, lst)
        lst.append(root.val)
        self.dfs(root.right, lst)


        