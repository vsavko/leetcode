/*Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
  Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  Constraints:
1 <= nums.length <= 8
-10 <= nums[i] <= 10*/ 
class Solution {
    
       public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(!map.containsKey(nums[i]))
                    map.put(nums[i],0);
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            return dfs(nums, 0, ans, new LinkedList<Integer>(), map);
            
        }
        
        private List<List<Integer>> dfs(int[] nums, int pos, List<List<Integer>> ans, 
                                        LinkedList<Integer> tmpAns, HashMap<Integer, Integer> 
                                            map){
            if (pos == nums.length){
                
                ans.add(new LinkedList<Integer>(tmpAns));
                return ans;
            }
            for (Integer key: map.keySet()){
                if (map.get(key) == 0) continue;
                map.put(key, map.get(key) - 1);
                tmpAns.add(key);
                dfs(nums, pos +1, ans, tmpAns, map);
                tmpAns.remove(tmpAns.size()-1);
                map.put(key, map.get(key) + 1);
            }
            return ans;
        }
}
