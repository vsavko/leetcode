/*You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
  Example 1:
Input: k = 2, prices = [2,4,1]
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:
Input: k = 2, prices = [3,2,6,5,0,3]
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
  Constraints:
0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000*/ 
class Solution {
    public static int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) return 0;
        ArrayList<Integer> buySell = new ArrayList<Integer>();
        int ans = 0;
        boolean bought = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] <= prices[i] && bought == false )
                continue;
            if (prices[i+1] > prices[i] && bought == false) {
                bought = true;
                buySell.add(prices[i]);
            }
            else if (bought == true && prices[i+1] < prices[i]) {
                buySell.add(prices[i]);
                bought = false;
            }   
        }
        if (bought)
            buySell.add(prices[prices.length - 1]);
        //System.out.println(buySell);

        
        
        int index = 0;
        while(buySell.size()/2 > k) {
            int minProfitChange = Integer.MAX_VALUE;
            String str = "none";
            //System.out.println(buySell);
            for(int i = 1 ; i < buySell.size(); i += 2) {
    
                //3 cases add sell to previous, add buy to next, just delete, see which is 
                    biggest
                int caseSell = Integer.MAX_VALUE, caseBuy = Integer.MAX_VALUE;
                
                //case none, not adding buy or sell, just remove the buy/sell pair
                int caseNone = buySell.get(i)-buySell.get(i-1); //amount of lost profit
                
                //check adding sell to previous
                if (i > 1) {
                    //profit before
                    int profitBefore = buySell.get(i)-buySell.get(i-1) + buySell.get(i-2) - 
                        buySell.get(i-3);
                    int profitAfter = buySell.get(i) - buySell.get(i-2);
                    caseSell = profitBefore - profitAfter;
                }
                
                //check adding buy to the next
                if (i < buySell.size() -2) {
                    int profitBefore = buySell.get(i)-buySell.get(i-1) + buySell.get(i+2) - 
                        buySell.get(i+1);
                    int profitAfter = buySell.get(i+2) - buySell.get(i-1);
                    caseBuy = profitBefore - profitAfter;
                }
                
                //System.out.println(caseBuy + " " + caseSell + " " + caseNone);
                
                if(caseBuy < caseSell && caseBuy < caseNone) {
                    if (caseBuy < minProfitChange) {
                        str = "buy";
                        index = i;
                        minProfitChange = caseBuy;
                    }
                }
                else if (caseSell < caseNone) {
                    if (caseSell < minProfitChange) {
                        str = "sell";
                        index = i;
                        minProfitChange = caseSell;
                    }
                }
                else if(caseNone <= caseSell && caseNone <= caseBuy && caseNone < 
                    minProfitChange) {
                    index = i;
                    str = "none";
                    minProfitChange = caseNone;
                }
            }
            
            //System.out.println("index" + index + " minProfitChange "+ minProfitChange + " 
                case " + str);
            
            if (str == "buy") {
                buySell.set(index+1, buySell.get(index-1));
            }
            if (str == "sell") {
                buySell.set(index-2, buySell.get(index));
            }


            buySell.remove(index-1);
            buySell.remove(index-1);
            
            //System.out.println(buySell);
        }
        
        
        
        for(int i = 1; i < buySell.size(); i += 2) {
            ans += (buySell.get(i) - buySell.get(i-1));
        }
        
        return ans;
    }
    
}
