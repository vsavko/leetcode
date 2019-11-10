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
