/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
  Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]
  Constraints:
1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.*/ 
class Solution {
public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> returnArray = new ArrayList<>();
            permutations(returnArray,new ArrayList<>(),new boolean[nums.length], 0, nums
                .length, nums);
            return returnArray;
        }
        
        private static void permutations (List<List<Integer>> returnArray, ArrayList<Integer> 
            tempArray, boolean [] numsTaken, 
                int start, int end, int [] nums){
            
            if (end == 0){
                returnArray.add(new ArrayList<Integer>(tempArray));
                return;
            }
            
            for(int i = 0; i < nums.length ; i++){

                int current = (start + i) % nums.length;
                if(numsTaken[current] == true) continue;
                
                tempArray.add(nums[current]);
                numsTaken[current] = true;
                permutations(returnArray, tempArray, numsTaken, start +1 , end -1, nums);
                numsTaken[current] = false;
                tempArray.remove(tempArray.size()-1);
            }
        }
    
}
