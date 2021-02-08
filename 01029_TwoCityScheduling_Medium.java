/*A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
  Example 1:
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
Example 2:
Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
Example 3:
Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086
  Constraints:
2 * n == costs.length
2 <= costs.length <= 100
costs.length is even.
1 <= aCosti, bCosti <= 1000*/ 
class Solution {
      public static int twoCitySchedCost(int[][] costs) {
          int totalCost = 0;
          int [][] dp = new int[costs.length][costs.length/2+1];
          for(int i = 0 ; i < costs.length; i++) {
              totalCost += costs[i][0];
          }
          //System.out.println("total " + totalCost);
          //System.out.println();
          return recursiveHelperMemo(costs, 0, totalCost, costs.length/2,dp);
      }
      
      
      private static int recursiveHelperMemo(int[][] costs, int position, int totalCost, int 
          personsLeft, int [][] dp) {
          if(personsLeft == 0) { 
              return totalCost;
          }
          if (dp[position][personsLeft] != 0 ) return dp[position][personsLeft];
          
          int minCost = Integer.MAX_VALUE;
          for(int i = position; i < costs.length && personsLeft <= costs.length - i; i++) {
              int tmp;
              tmp = recursiveHelperMemo(costs, i +1, 0, personsLeft-1, dp) - costs[i][0] + 
                  costs[i][1];
              if (tmp < minCost) minCost = tmp;
          }
          dp[position][personsLeft] = minCost;
          return totalCost + minCost;
      }
      
}
