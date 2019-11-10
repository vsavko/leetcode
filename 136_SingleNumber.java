/*Given a non-empty array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

class Solution {
	    public static int singleNumber(int[] nums) {
	        Map<Integer,Boolean> hm = new HashMap<>();
	        for (int key: nums) {
	        	if (hm.containsKey(key))
	        		hm.put(key,false);
	        	else
	        		hm.put(key,true);
	        }
	        for(int key: hm.keySet()) {
	        	if (hm.get(key) == true)
	        		return key; 
	        }
	        return -1;
	    }
}
