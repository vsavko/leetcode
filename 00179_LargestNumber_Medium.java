/*Given a list of non-negative integers nums, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.
  Example 1:
Input: nums = [10,2]
Output: "210"
Example 2:
Input: nums = [3,30,34,5,9]
Output: "9534330"
Example 3:
Input: nums = [1]
Output: "1"
Example 4:
Input: nums = [10]
Output: "10"
  Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 109*/ 
class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] =  Integer.toString(nums[i]);
        }
        //System.out.println(Arrays.toString(arr));
    
        Arrays.sort(arr, new comp());
        //System.out.println(Arrays.toString(arr));
        String ans = "";
        boolean isZero = true;
        for (String num: arr) {
            if (!num.equals("0"))
                isZero = false;
            if (!isZero)
                ans += num;
        }
        if (isZero)
            ans+= "0";
        
        return ans;

    }
    
    class comp implements Comparator<String> {
        public int compare(String a, String b) {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        }
    }
}
