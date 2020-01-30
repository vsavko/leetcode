/*Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {
	

	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> returnArray = new ArrayList<>();
    	combinations(returnArray, new ArrayList<Integer>(), 0, 0, candidates, target);
    	return returnArray;
    }
    
    private static void combinations (List<List<Integer>> retrunArray, ArrayList<Integer> returnLsit, 
    		int sum, int candidate, int [] candidates, int target){    
    	
    	sum += candidate;
    	if (sum > target) return;
    	
    	ArrayList<Integer> newList = new ArrayList<>(returnLsit);
    	
    	if (candidate != 0)
    		newList.add(candidate);
    	
    	if (sum == target) {
    		Collections.sort(newList);
    		if (!retrunArray.contains(newList))
    			retrunArray.add(newList);
    		return;
    	}
    	
    	for(int i = 0; i < candidates.length; i++) {
    		combinations(retrunArray,newList,sum,candidates[i],candidates,target);
    	}
    }
    
    public static void main(String[] args) {
    	int [] arr= {};
    	int target = 5;
		System.out.println(combinationSum(arr,target));
	}
    
}
