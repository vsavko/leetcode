/*Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
  Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:
Input: digits = ""
Output: []
Example 3:
Input: digits = "2"
Output: ["a","b","c"]
  Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].*/ 
class Solution {
    public static List<String> letterCombinations(String digits) {
    
        List<String> ans = new ArrayList<String>();
        
        if(digits==null || digits.length()==0) return ans;
        
        char[][] map = new char[8][];
        
        map[0]="abc".toCharArray();
        map[1]="def".toCharArray();
        map[2]="ghi".toCharArray();
        map[3]="jkl".toCharArray();
        map[4]="mno".toCharArray();
        map[5]="pqrs".toCharArray();
        map[6]="tuv".toCharArray();
        map[7]="wxyz".toCharArray();
        
        char[] input = digits.toCharArray();
        
        ans.add("");
        
        for(char c:input) {
            //System.out.println(c);
            ans = expand(ans,map[c-'2']);
        }
        
        return ans;
        
        
    }

    private static List<String> expand(List<String> l, char[] arr)
    {
        List<String> next = new ArrayList<String>();
        
        for(String s:l) {
            for(char c:arr) {
                next.add(s+c);
            }
        }
        
        return next;
    }
    
}
