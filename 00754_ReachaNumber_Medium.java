/*You are standing at position 0 on an infinite number line. There is a goal at position target.
On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
Return the minimum number of steps required to reach the destination.
Example 1:
Input: target = 3
Output: 2
Explanation:
On the first move we step from 0 to 1.
On the second step we step from 1 to 3.
Example 2:
Input: target = 2
Output: 3
Explanation:
On the first move we step from 0 to 1.
On the second move we step  from 1 to -1.
On the third move we step from -1 to 2.
Note:
target will be a non-zero integer in the range [-10^9, 10^9].*/ 
class Solution {
    public static int reachNumber(int target) {
        long target2 = Math.abs(target);
        double n = (1 + Math.sqrt(1+8*target2))/2; //solve for arithmetic sum
        if ((n == Math.floor(n)) && !Double.isInfinite(n)) {
            return (int) n - 1;
        }
        else {
            int num = (int) Math.ceil(n);
            int Sn = (num-1)*num/2;
            if((target2-Sn) %2 == 0)
                return num -1;
            if((target2-Sn ) %2+ num %2 == 0)
                return num ;
            if((target2-Sn ) %2 + (num + 1) %2 == 0)
                return num +1;
        }
        return 0;
    }
}
