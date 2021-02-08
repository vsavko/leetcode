/*Given a non-empty array of integers, return the k most frequent elements.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:
Input: nums = [1], k = 1
Output: [1]
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
You can return the answer in any order.*/ 
class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> hm = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i],0);
            hm.put(nums[i], hm.get(nums[i]) +1);
        }
        
        HashMap<Integer,ArrayList<Integer>> hm2 = new HashMap<>();
        for(Integer key: hm.keySet()) {
            int ammountOfInteger = hm.get(key);
            if(!hm2.containsKey(ammountOfInteger)){
                hm2.put(ammountOfInteger, new ArrayList<Integer>());
            }
            hm2.get(ammountOfInteger).add(key);
            
        }
       
        ArrayList<Integer> keys = new ArrayList<>(hm2.keySet());
        Collections.sort(keys, Collections.reverseOrder());
        
        int [] ans = new int[k];
        
        //System.out.println(keys);
        //System.out.println(hm);
        //System.out.println(hm2);
        
        for(int i = 0, j = 0, count = 0; count < k && count < hm.size(); i++) {
            while(j < hm2.get(keys.get(i)).size() && count < k ) {
                ans[count++] = hm2.get(keys.get(i)).get(j);
                j++;
            }
            j = 0;
        }
        

        return ans;
    }
}
