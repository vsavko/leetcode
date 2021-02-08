/*Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
Return the quotient after dividing dividend by divisor.
The integer division should truncate toward zero, which means losing its fractional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
Note:
Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
  Example 1:
Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = truncate(3.33333..) = 3.
Example 2:
Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = truncate(-2.33333..) = -2.
Example 3:
Input: dividend = 0, divisor = 1
Output: 0
Example 4:
Input: dividend = 1, divisor = 1
Output: 1
  Constraints:
-231 <= dividend, divisor <= 231 - 1
divisor != 0*/ 
class Solution {
     public static int divide(int dividend, int divisor) {
            if (divisor == 0) throw new IllegalArgumentException("Cannot divide by 0!");
            int signNum = Integer.signum(dividend) * Integer.signum(divisor);

            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);

            if ((divisor > dividend && dividend != Integer.MIN_VALUE )|| dividend == 0) return 
                 0;

            int divisorBits = 0;
            int dividendBits = 0; 
            int leftBits, ans = 0;
            
            int tmp = dividend;
            while(tmp != 0) {
                ++dividendBits;
                tmp = tmp >>> 1;
            }
            
            tmp = divisor;
            while(tmp != 0) {
                ++divisorBits;
                tmp = tmp >>> 1;
            }
            if (dividendBits == divisorBits ) return 1*signNum; //make sure leftBits > 0
            leftBits = dividendBits - divisorBits;
            
            int tempDividend = dividend >>> (dividendBits - divisorBits);
            //System.out.println(Integer.toBinaryString(tempDividend) + " " + dividendBits + " 
                divisorBits " + divisorBits);
            boolean addNext = false;

            while(leftBits> 0) {
                //System.out.println("t1 " + Integer.toBinaryString(tempDividend) + " " + 
                    Integer.toBinaryString(divisor));
                //System.out.println(Integer.toBinaryString(tempDividend));
                if(tempDividend < divisor) {
                    --leftBits;
                    if (addNext == true) addNext = false;
                    else ans <<= 1;
                    tempDividend <<= 1;
                    int mask = 1 << leftBits ; // extract next bit from dividend
                    //System.out.println("mask "+ leftBits + " " + Integer.toBinaryString(mask
                        ));
                    tempDividend |= (dividend & mask) >> (leftBits); // add next bit to temp 
                        dividend
                    
                }
                
                //System.out.println(Integer.toBinaryString(tempDividend));
                if (tempDividend >= divisor || tempDividend == Integer.MIN_VALUE){
                    ans <<= 1;
                    ans |= 1;
                    tempDividend = tempDividend - divisor;
                    addNext = true;
                }
                else if (leftBits == 0) {
                    //System.out.println("test");
                    ans <<= 1;
                }
            }
            //System.out.println(ans + " " + signNum);
            
            if (ans == Integer.MIN_VALUE) {
                if(signNum > 0) ans = Integer.MAX_VALUE;
            }
            
            return ans*signNum;
     }
}
