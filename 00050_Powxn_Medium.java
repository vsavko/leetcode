/*Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
  Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
  Constraints:
-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104*/ 
class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            if (x == 1 || x == -1) return 1;
            else return 0;
        }

        if (n < 0) return myPow(1/x, -n);
        double ans = 1;
        while(n > 0) {
            //we are checking how many times the number should be multiplied by itself
            //so if we have a 17^17, it would be 17^(2^4 +1)=17^2^4 * 17
            double tmp = x;
            int pow = log2nlz(n); //math floor of log2(n)
            n -= (pow > 0 ) ? (2 << pow-1) : 1; //subtract 2^x from the power
            if (pow == 0) n = 0;
            //System.out.println(tmp + " " + pow);
            for(int i = 0; i < pow; i++) {
                tmp *= tmp;
            }
            ans *= tmp;
        }
        return ans;
    }
    
    //fast log2 (n) calculation
    public static int log2nlz( int bits )
    {
        if( bits == 0 )
            return 0; // or throw exception
        return 31 - Integer.numberOfLeadingZeros( bits );
    }
}
