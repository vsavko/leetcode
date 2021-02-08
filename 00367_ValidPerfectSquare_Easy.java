/*Given a positive integer num, write a function which returns True if num is a perfect square else False.
Follow up: Do not use any built-in library function such as sqrt.
  Example 1:
Input: num = 16
Output: true
Example 2:
Input: num = 14
Output: false
  Constraints:
1 <= num <= 2^31 - 1*/ 
class Solution {
    public static boolean isPerfectSquare(int num) {
        int tmpNumBottom = 1;
        int tmpNumUP = 46340;
        while(tmpNumBottom <= tmpNumUP){
            int tmpNum = (tmpNumUP + tmpNumBottom) / 2;
            int squared = tmpNum*tmpNum;
            if (squared == num) return true;
            else if(squared > num) tmpNumUP = tmpNum - 1;
            else tmpNumBottom = tmpNum + 1;
        }
        return false;
    }
}
