/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?*/


class Solution {
public static boolean isPalindrome(int x) {
		if (x<0) return false;
		int num = x, len = 0;
		int [] array = new int [10];
		while (num > 0) {
			array[len++] = num % 10;
			num /= 10;
		}
		for (int i=0, z = len-1; i<z; ) {
			if (array[i++] != array[z--])
				return false;
		}
		return true;
	}
}
