/*Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
  Example 1:
Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:
Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
  Constraints:
1 <= n <= 104*/ 
class Solution {
    
    HashMap<Integer, Integer> memo = new HashMap<>();

    public int numSquares(int n) {
        return numSquaresRecursive(n);
    }
    
    private int numSquaresRecursive(int n) {
        if( memo.containsKey(n))
                return ( memo.get(n));
        
        if(n < 0){
            return -1;
        }
        if( n == 0){
            return 0;
        }
        //find max perfect square for n
        int perfectMax = (int)Math.floor(Math.sqrt(n));
        int tmpMin, min = Integer.MAX_VALUE;
        for(int i = perfectMax; i > 0; i--){
            int pow2 = (int)Math.pow(i,2);
            tmpMin = numSquaresRecursive(n - pow2) +1;
            //System.out.println("i " + i + " tmpMin " + tmpMin) ;
            if (tmpMin > 0 && tmpMin < min)
                min = tmpMin;  
        }
        memo.put(n,min);
        
        return min;  
    }
}
