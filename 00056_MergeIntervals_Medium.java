/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
  Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
  Constraints:
1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104*/ 
class Solution {
        
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) return new int [0][];
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        //System.out.println(Arrays.deepToString(intervals));
        ArrayList<int []> ans = new ArrayList<>();
        int [] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(curr[1] >= intervals[i][0]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            else {
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);
        int [][] ans2 = new int [ans.size()][];
        for(int i = 0; i < ans2.length; i++) {
            ans2[i] = ans.get(i);
        }
        //System.out.println(Arrays.deepToString(ans2));
        return ans2;
    }
    
}
