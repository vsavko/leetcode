'''Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
  Example 1:
Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
Example 4:
Input: prices = [1]
Output: 0
  Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 105''' 
from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minbuy1 = float('inf')
        minbuy2 = float('inf')
        profit = 0
        profit1 = 0
        tmpProfit = 0
        for i in range(0, len(prices)):
            # max1 for only one buy and sell deal
            if prices[i] - profit < minbuy2:
                minbuy2 = prices[i] - profit
            if prices[i] - minbuy2 > profit1:
                profit1 = prices[i] - minbuy2

            if i > 0 and prices[i - 1] < minbuy1:
                minbuy1 = prices[i - 1]
            if prices[i] - minbuy1 > profit:
                profit = prices[i] - minbuy1
            #print(i , prices[i], profit, profit1, minbuy2)
        return profit1
