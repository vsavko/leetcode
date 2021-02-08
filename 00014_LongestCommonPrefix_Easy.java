/*Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
  Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
  Constraints:
0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.*/ 
class Solution {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder("");
        if (strs == null || strs.length == 0) return commonPrefix.toString();
        if (strs.length == 1 ) return strs[0];
        int pos = 0;
        while(true){
            for(int i=0; i < strs.length; i++){
                if (pos >= strs[i].length() || (i > 0 && strs[i].charAt(pos) != strs[i-1]
                    .charAt(pos))) return commonPrefix.toString();
            }
            commonPrefix.insert(pos, strs[0].charAt(pos)) ; 
            ++pos;
        }
    }
}
