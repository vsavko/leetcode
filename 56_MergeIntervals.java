/*Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/

import java.util.Arrays;

public class MergeIntervals {
	
	public static int [][] merge(int[][] intervals) {
		int size1 = intervals.length, size2 = 0;
		int [][] inv2 = new int[0][];
		while(size1 != size2) {
			size1 = size2;
			inv2 = merge2(intervals);
			size2 = inv2.length;
		}
		return inv2;
	}
	
    public static int[][] merge2(int[][] intervals) {
    	int count = 0;
    	boolean [] tmp = new boolean [intervals.length];
    	for(int i = 0; i < intervals.length; i++) {
    		if (tmp[i] == true) continue;
    		for(int j = 0; j < intervals.length; j++) {
    			if (tmp[j] == true || i == j) continue;
    			if (intersect(intervals[i],intervals[j])) {
    				intervals[i] = merge(intervals[i],intervals[j]);
    				tmp[j] = true;
    				++count;
    			}
    		}
    	}
    	
        int [][] arr = new int[tmp.length-count][];
        for(int i = 0, j = 0; i <tmp.length; i++) {
        	if (tmp[i] == false) {
        		arr[j++] = intervals[i];
        	}
        }
        return arr;
    }
    
    private static boolean intersect (int [] inv1, int [] inv2) {
    	if (inv1[0] <= inv2[1] && inv2[0] <= inv1[1])
    		return true;
    	return false;
    }
    
    private static int [] merge(int [] inv1, int [] inv2) {
    	int [] arr = {Math.min(inv1[0], inv2[0]),Math.max(inv1[1], inv2[1])};
    	return arr;
    }
    
    public static void main(String[] args) {
		int [][] arr =	{{1,3},{2,6},{8,10},{15,18}};
		System.out.println(Arrays.deepToString(merge(arr)));
	}
}
