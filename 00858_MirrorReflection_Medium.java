/*There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
  Example 1:
Input: p = 2, q = 1
Output: 2
Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
Note:
1 <= p <= 1000
0 <= q <= p*/ 
class Solution {
public static int mirrorReflection(int p, int q) {
        boolean isLeft = true;
        boolean isUp = true;
        int YPos = 0;
        while(true) {
            if(isUp) {
                if (YPos + q <= p) {
                    //System.out.println("test");
                    YPos += q;
                }
                else{
                    YPos = p - (q - (p - YPos));
                    isUp = false;
                }
            }
            else {
                if (YPos - q >= 0) {
                    YPos -= q;
                }
                else {
                    YPos = q - YPos;
                    isUp = true;
                }
            }
            isLeft = !isLeft;
            if(isLeft && YPos == p) return 2;
            if(!isLeft && YPos == p) return 1;
            if(!isLeft && YPos == 0) return 0;
            //System.out.println(isLeft + " YPos " + YPos + " isUp " + isUp);
        }
    }
}
