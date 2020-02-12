	/*Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]*/
  
  public List<List<Integer>> levelOrder(TreeNode root){
		ArrayList<List<Integer>> answer = new ArrayList<>();
		return levelOrder2(root, 1 , answer);
	}
    
    public List<List<Integer>> levelOrder2(TreeNode root, int level, ArrayList<List<Integer>> answer) {
    	if (root == null) return answer;
    	if (answer.size() < level) answer.add(level - 1, new ArrayList<Integer>());
    	answer.get(level-1).add(root.val);
    	levelOrder2(root.left, level +1, answer);
    	levelOrder2(root.right, level +1, answer);
		return answer;
    }
