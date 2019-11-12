class Solution {
    //brute force with O(n^2) time complexity, and O(1) memory
    public int[] twoSum(int[] nums, int target) {
        int [] array = new int[2];
        for (int i =0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return null;
    }
    
    //using a hash map with O(n) time complexity and O(n) memory
    public static int[] twoSum2(int[] nums, int target) { //how to pass array starting from certain index?
    	Map<Integer,Integer> hashMap = new HashMap<>();
    	for(int i = 0; i < nums.length; i++) {
    		if(hashMap.containsKey(target - nums[i])) {
    			return new int[] {i, hashMap.get(target - nums[i])};
    		}
    		hashMap.put(nums[i], i);
    	}
    	return null;
    }
}
