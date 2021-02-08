/*The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
  Example 1:
Input: n = 3, k = 3
Output: "213"
Example 2:
Input: n = 4, k = 9
Output: "2314"
Example 3:
Input: n = 3, k = 1
Output: "123"
  Constraints:
1 <= n <= 9
1 <= k <= n!*/ 
class Solution {
    
    
    public String getPermutation(int n, int k) {
        int [] factorial = new int [n+1];
        factorial[0] = 1;
        String ans = "";
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        for(int i = 1; i <= n; i++){
            factorial[i] = factorial[i-1] *i; 
            set.add(i);
        }
        
        
        
        for(int i = 1; i <=n; i++){
            int power = 0;
            for(int j = 1; j <= n; j++){
                if(!set.contains(j)) {
                    continue;
                }
                ++power;
                System.out.println(power + " " + k + " " + factorial[n-i] +  " " + (n-i));
                if(power * factorial[n-i] >= k){
                    set.remove(j);
                    
                    //int rem = k % power;
                    k = k - factorial[n-i] * (power -1);// + rem;
                    
                    ans += j;
                    break;
                }
            }
        }
        
        return ans;
    }
    

}
