/*Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:
Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]*/ 
class Solution {
    public static int maxProfit(int[] prices) {
        int [] dp = new int[prices.length];
        if (prices.length <= 1) return 0;
        int maxInc = Integer.MIN_VALUE;
        
        for(int i = 0; i < prices.length; i++){  
            //System.out.println(maxInc);
            if ( i > 0)
                dp[i] = Math.max(0, Math.max(dp[i-1], prices[i] + maxInc));
            int prevIncome = (i > 2) ? dp[i -2] : 0;
            if (prevIncome - prices[i] > maxInc) maxInc = prevIncome - prices[i];
        }
        
        //System.out.println(Arrays.toString(dp));
        return dp[prices.length -1];       
    }
}
