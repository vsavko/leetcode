/*Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.
  Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:
Input: s = "a"
Output: [["a"]]
  Constraints:
1 <= s.length <= 16
s contains only lowercase English letters.*/ 
class Solution {
     public List<List<String>> partition(String s) {
        @SuppressWarnings("unchecked")
        List<List<String>> [][] memo = (List<List<String>> [][]) new ArrayList[s.length()][s
            .length()];
        
        for(int k = 1; k <= s.length(); k++) {
            for(int left = 0; left <= s.length() - k; left++) {
                int right = left + k -1;
                
                memo[left][right] = new ArrayList<>();
                //System.out.println(left + " " + right);
                if(isPalindrome(s,left,right)) {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(s.substring(left, right+1));
                    memo[left][right].add(tmp);
                }
                
                for(int j = left; j < right; j++) {
                    //System.out.println("left " + left + " right " + right);
                    //System.out.println(s.substring(left, j+1));
                    if (isPalindrome(s,left,j) && memo[j+1][right].size() > 0){
                            //System.out.println("j" + j);
                            for(List<String> lst2: memo[j+1][right]) {
                                ArrayList<String> tmp2 = new ArrayList<>();
                                tmp2.add(s.substring(left, j+1));
                                //System.out.println("tmp2" + tmp2);
                                tmp2.addAll(lst2);
                                memo[left][right].add(tmp2);
                                //System.out.println("tmp2" + tmp2);
                        }           
                    }
                }
            }
        }

        return memo[0][s.length()-1];
    }
    
    private boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}
