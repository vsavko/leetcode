/*You may recall that an array arr is a mountain array if and only if:
arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
  Example 1:
Input: arr = [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:
Input: arr = [2,2,2]
Output: 0
Explanation: There is no mountain.
  Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 104
  Follow up:
Can you solve it using only one pass?
Can you solve it in O(1) space?*/ 
class Solution {
    public int longestMountain(int[] A) {
        boolean mountain_grow = false;
        boolean mountain_shrink = false;
        boolean can_be = false;
        int len = 0;
        int maxLen = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i-1] < A[i]){
                if (mountain_shrink == false && mountain_grow == false){
                    can_be = true;
                    mountain_grow = true;
                    len = 2;
                }
                else if (mountain_grow == true){
                    ++len;
                }
                else if (mountain_shrink == true){
                    if (maxLen < len){
                        maxLen = len;
                    }
                        len =  2;
                        mountain_shrink = false;
                        mountain_grow = true;
                    
                }
            }
            else if(A[i-1] > A[i] && can_be == true){
                if (mountain_shrink == true){
                    ++len;
                }
                else if (mountain_grow == true){
                    ++len;
                    mountain_shrink = true;
                    mountain_grow = false;
                }
            }
            else{
                if (mountain_shrink == true){
                    if (maxLen < len)
                        maxLen = len;
                }
                len = 0;
                can_be = false;
                mountain_shrink = false;
                mountain_grow = false;
                
            }
       // System.out.println("i " +i + " " + len + " " + can_be + " " + mountain_grow + " " + 
           mountain_shrink);
        }
        if (maxLen < len && mountain_shrink == true)
            maxLen = len;
        return maxLen;
    }
}
