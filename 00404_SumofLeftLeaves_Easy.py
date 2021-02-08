'''Find the sum of all left leaves in a given binary tree.
Example:
    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.''' 
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        if root is None:
            return 0
        sum = 0
        if root.left is not None and root.left.left is None and root.left.right is None:
            sum += root.left.val
        sum += self.sumOfLeftLeaves(root.left)
        sum += self.sumOfLeftLeaves(root.right)
        return sum
