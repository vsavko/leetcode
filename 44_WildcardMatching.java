/*Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false*/


public class WildcardMatching2 {
	
	public static boolean isMatch(String s, String p) {
		int sCounter = 0, pCounter = 0, pStarCounter  = -1, sStarCounter = -1;
		
		while(sCounter < s.length()) {
			System.out.println(sCounter + " " +pCounter );
			if (pCounter < p.length() && p.charAt(pCounter) == '*'){
				pStarCounter = pCounter;
				sStarCounter = sCounter;
				++pCounter;
			}
			else if(pCounter < p.length() && (s.charAt(sCounter) == p.charAt(pCounter) || p.charAt(pCounter) == '?')) {
				++sCounter;
				++pCounter;
			}
			else {
				if (sStarCounter != -1) {
					++sStarCounter;
					sCounter = sStarCounter;
					pCounter = pStarCounter +1;
				}
				else
					return false;
			}
		}
		
		while(pCounter < p.length() && p.charAt(pCounter) == '*') ++pCounter;
		
		return (sCounter == s.length() && pCounter == p.length());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test ="acdcb";
		String test2 ="a*c?b";
		
		
		System.out.println(isMatch(test,test2));

	}

}
