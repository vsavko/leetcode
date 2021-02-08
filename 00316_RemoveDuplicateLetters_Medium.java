/*Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
  Example 1:
Input: s = "bcabc"
Output: "abc"
Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
  Constraints:
1 <= s.length <= 104
s consists of lowercase English letters.*/ 
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!hm.containsKey(c))
                hm.put(c,0);
            hm.put(c, hm.get(c)+1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.contains(c)) {
                while(!stack.isEmpty() && c < stack.peek() && hm.get(stack.peek()) > 0)
                    stack.pop();
                stack.add(c);
            }
            hm.put(c, hm.get(c)-1);
        }
        
        String ans = "";
        for (int i =0; i < stack.size(); i++) {
            ans += stack.get(i);
        }
        return ans;
    }
    
}
