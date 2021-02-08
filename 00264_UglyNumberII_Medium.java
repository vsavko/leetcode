/*Write a program to find the n-th ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
Example:
Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  
1 is typically treated as an ugly number.
n does not exceed 1690.*/ 
class Solution {
    public static int nthUglyNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        int [] dp = new int [1690];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        dp[3] = 4;
        dp[4] = 5;
        int ptr1 = 2, ptr2 = 1, ptr3 = 1; //ptr1 - *2, ptr2 - *3, ptr3 - *5 
        // iterate through the current array until some other pointer gives less value
        for(int i = 5; i < n; i++){
            int tmp;
            if(dp[ptr1]*2 <= dp[ptr2]*3 && dp[ptr1]*2 <= dp[ptr3]*5) {
                tmp = dp[ptr1]*2;
                set.add(tmp);
                ++ptr1;
                //System.out.println(ptr1 + " " + ptr2 + " " + ptr3);
                while(set.contains(dp[ptr2]*3)) ++ptr2;
                while(set.contains(dp[ptr3]*5)) ++ptr3;
            }
            else if(dp[ptr2]*3 <= dp[ptr1]*2 && dp[ptr2]*3 <= dp[ptr3]*5) {
                tmp = dp[ptr2]*3;
                ++ptr2;
                set.add(tmp);
                
                while(set.contains(dp[ptr1]*2)) ++ptr1;
                while(set.contains(dp[ptr3]*5)) ++ptr3;
            }
            else  { //if(val3 <= val1 && val3 <= val2)
                tmp = dp[ptr3]*5;
                ++ptr3;
                set.add(tmp);
                
                while(set.contains(dp[ptr1]*2)) ++ptr1;
                while(set.contains(dp[ptr2]*3)) ++ptr2;
            }
            //System.out.println("i " + i + " "+ tmp);
            dp[i] = tmp;
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n-1];
    }
}
