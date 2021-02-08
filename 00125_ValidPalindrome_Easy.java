/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:
Input: "race a car"
Output: false
  Constraints:
s consists only of printable ASCII characters.*/ 
class Solution {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) < '0' || (s.charAt(i) > '9' &&  s.charAt(i) < 'A') || (s.charAt(i) 
                > 'Z' && s.charAt(i) < 'a') || s.charAt(i) > 'z')
                ++i;
            else if (s.charAt(j) < '0' || (s.charAt(j) > '9' &&  s.charAt(j) < 'A') ||(s
                .charAt(j) > 'Z' && s.charAt(j) < 'a') || s.charAt(j) > 'z')
                --j;
            else {
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) 
                    return false;
                ++i;
                --j;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String str = ",.";
        System.out.println(isPalindrome(str));
    }
}
