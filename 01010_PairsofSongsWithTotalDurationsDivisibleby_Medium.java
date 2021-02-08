/*You are given a list of songs where the ith song has a duration of time[i] seconds.
Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
  Example 1:
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:
Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
  Constraints:
1 <= time.length <= 6 * 104
1 <= time[i] <= 500*/ 
class Solution {
        public static int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int time2 [] = new int[60];
        for(int i =0; i<time.length; i++){
            ++time2[time[i] % 60];
        }
        //System.out.println(Arrays.toString(time2));
        //System.out.println(time2[30] );
        
        for(int i = 0; i < time.length; i++){
            int val = time[i]%60;
            //System.out.println(val);
            if(val < 30 && val > 0){
                ans += time2[60-val];
            }
            else if(val == 30 ){
                ans += time2[30] - 1;
                time2[30] -= 1;
            }
            else if(val == 0 ){
                ans += time2[0] - 1;
                time2[0] -= 1;
            }
         //System.out.println(time[i] + " " +time2[i] + " " + ans);
        }
        return ans;
    }
}
