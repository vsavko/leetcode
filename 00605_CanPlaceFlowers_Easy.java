/*You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
  Example 1:
Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
  Constraints:
1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length*/ 
class Solution {
     public static boolean canPlaceFlowers(int[] flowerbed, int n) {
            if(n==0) return true;
            if(flowerbed.length == 0) return (n == 0)? true: false;
            if(flowerbed.length == 1){
                if (n <= 1 && flowerbed[0]==0)
                    return true;
                else
                    return false;
            } 
            
            int [] dp = new int[flowerbed.length];
            
            for(int i = 0; i < flowerbed.length; i++){
                if(i == 0){
                    if(flowerbed[1] != 1 && flowerbed[0] != 1)
                        dp[0] = 1;
                }
                else if(i == flowerbed.length-1){
                    if(flowerbed[flowerbed.length-1] != 1 && flowerbed[flowerbed.length-2] != 
                        1)
                        dp[flowerbed.length-1] = Math.max(dp[flowerbed.length-2],
                        (flowerbed.length >= 3)? dp[flowerbed.length-3]+1: 1); 
                    else
                     dp[flowerbed.length-1] = Math.max(dp[flowerbed.length-2],
                        (flowerbed.length >= 3)? dp[flowerbed.length-3]: 0); 
                }
                else{
                    if(flowerbed[i-1] != 1 && flowerbed[i+1] != 1 && flowerbed[i] != 1){
                        if(i == 1)
                            dp[i] = Math.max(1, dp[i-1]);
                        else
                            dp[i] = Math.max(dp[i-2] + 1, dp[i-1]);
                    }
                    else{
                        if(i == 1){
                            dp[i] = dp[i-1];
                        }
                        else
                            dp[i] = Math.max(dp[i-2], dp[i-1]);
                    }
                }
            }
            //System.out.println(Arrays.toString(dp));
            return dp[flowerbed.length-1] >= n ? true: false;
        }
}
