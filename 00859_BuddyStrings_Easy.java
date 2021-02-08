/*Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.
Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
  Example 1:
Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
Example 2:
Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
Example 3:
Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
Example 4:
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:
Input: A = "", B = "aa"
Output: false
  Constraints:
0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist of lowercase letters.*/ 
class Solution {
    public boolean buddyStrings(String A, String B) {
        //if two non equal characters in strings, then can swap
        //if strings are equal check if there are 2 same characters for each string
        
        if (A.length() != B.length()) return false;
        HashSet<Character> set = new HashSet<>();
        int diff_letters = 0;
        boolean same_letters = false;
        int charDiff = -1;
        for(int i = 0; i < A.length(); i++){
            if (A.charAt(i) != B.charAt(i)){
                if (charDiff == -1)
                    charDiff = i;
                ++diff_letters;
            }
            
            if(A.charAt(i) != B.charAt(i) && diff_letters == 2){
                if (!(A.charAt(charDiff) == B.charAt(i) && 
                    B.charAt(charDiff) == A.charAt(i)))
                    return false;
            }
            
            if (set.contains(A.charAt(i)))
                same_letters = true;
            
            set.add(A.charAt(i));
        }
        if (diff_letters == 2) return true;
        if (diff_letters == 0 && same_letters)
            return true;
        return false;
    }
}
