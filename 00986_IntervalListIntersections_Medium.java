/*You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
  Example 1:
Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Example 2:
Input: firstList = [[1,3],[5,9]], secondList = []
Output: []
Example 3:
Input: firstList = [], secondList = [[4,8],[10,12]]
Output: []
Example 4:
Input: firstList = [[1,7]], secondList = [[3,10]]
Output: [[3,7]]
  Constraints:
0 <= firstList.length, secondList.length <= 1000
firstList.length + secondList.length >= 1
0 <= starti < endi <= 109
endi < starti+1
0 <= startj < endj <= 109
endj < startj+1*/ 
class Solution {
  public static int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A == null || B == null ) return new int [0][0];
        if(A.length == 0  || B.length == 0 ) return new int [0][0];
        if(A[0].length == 0 || B[0].length == 0 ) return new int [0][0];
        
        if (A.length > B.length)
            return intervalIntersection(B, A);
        
        int ptr1 = 0, ptr2 = 0;
        ArrayList<int[]> arr = new ArrayList<>();
        
        while(ptr1 < A.length && ptr2 < B.length) {
            int min1 = A[ptr1][0];
            int min2 = B[ptr2][0];
            int max1 = A[ptr1][1];
            int max2 = B[ptr2][1];
            
            if(min1 <= max2 && min2 <= max1) {
                int [] tmp = new int [2];
                tmp[0] = Math.max(min1, min2);
                tmp[1] = Math.min(max1, max2);
                arr.add(tmp);
            }
            
            if(max2 > max1) ++ptr1;
            else ++ptr2;
        }
        
       int [][]ans = new int[arr.size()][2];
       
       for(int i = 0; i < arr.size(); i++) {
           ans[i] = arr.get(i);
       }
       
       return ans;
    }
}
