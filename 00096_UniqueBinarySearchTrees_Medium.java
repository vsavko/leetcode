/*Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
  Example 1:
Input: n = 3
Output: 5
Example 2:
Input: n = 1
Output: 1
  Constraints:
1 <= n <= 19*/ 
class Solution {
     int [] memo;
        public int numTrees(int n) {
            memo = new int[n+1];
            memo[0] = 1;
            return recursive(n);
        }
        
        private int recursive(int n){
            if(memo[n] != 0) return memo[n];
            int ans = 0;
            for(int i = 0; i < n; i++){
                int left = i;
                int right = n -i - 1;
                int ansLeft = 0, ansRight = 0;
                if (memo[left] != 0){
                    ansLeft = memo[left] ;
                }
                else{
                    ansLeft = recursive(left);
                }
                
                if (memo[right] != 0){
                    ansRight = memo[right] ;
                }
                else{
                    ansRight = recursive(right);
                }
                ans += (ansLeft*ansRight);
            }
            memo[n] = ans;
            return ans;
        }
        
}
