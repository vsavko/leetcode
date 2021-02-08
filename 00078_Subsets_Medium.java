/*Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.
  Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]
  Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.*/ 
class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        ans.add(new LinkedList<Integer>());
        recursiveHelper(nums, 0, ans, new ArrayList<Integer>());
        return ans;  
    }
    
    private static void recursiveHelper(int [] nums, int start, List<List<Integer>> ans, 
        ArrayList<Integer> tmp){
        if(start > nums.length -1) return;
        tmp.add(nums[start]);
        ans.add(new ArrayList<Integer>(tmp));
        recursiveHelper(nums,start+1,ans,tmp);
        tmp.remove(tmp.size()-1);
        recursiveHelper(nums,start+1,ans,tmp);
    }
}
