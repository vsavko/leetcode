/*Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Notice that the solution set must not contain duplicate triplets.
  Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:
Input: nums = []
Output: []
Example 3:
Input: nums = [0]
Output: []
  Constraints:
0 <= nums.length <= 3000
-105 <= nums[i] <= 105*/ 
class Solution {
public static List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list3 = new ArrayList<>();
            if (nums.length < 3) return list3;
            List<Integer> list2;
            List<int[]> retrunList; 
            for (int i = 0; i < nums.length; i++) {
                if (i>0 && nums[i] == nums[i-1]) {
                    continue; //skip duplicate triplets
                }
                if ((retrunList = twoSum1(nums, -nums[i], i+1)) != null) {
                    for (int[] arr: retrunList) {
                        list2 = new ArrayList<Integer>();
                        list2.add(nums[i]);
                        list2.add(arr[0]);
                        list2.add(arr[1]);
                        list3.add(list2);
                    }
                }
            }
            return list3;
        }
        
        
        public static List<int[]> twoSum1(int[] nums, int target, int arrIndex) { //how to 
            pass array starting from certain index?
            List<int[]> retrunList = new  ArrayList<>();
            int x = arrIndex;
            int y = nums.length-1;
            while(x < y) {
                if(nums[x] <= target - nums[y]) {
                    if(x > arrIndex && nums[x-1] == nums[x]) {
                        x++;
                        continue;
                    }
                    if (nums[x] == target - nums[y]) {
                        retrunList.add(new int[] {nums[y], nums[x]});
                    }
                    x++;
                }
                if(nums[y] > target - nums[x]) {
                    if(y < nums.length-1 && nums[y+1] == nums[y]) {
                        y--;
                        continue;
                    }
                    if (nums[y] == target - nums[x]) {
                        retrunList.add(new int[] {nums[x], nums[y]});
                    }
                    y--;
                }
            }
            return retrunList;
        }

}
