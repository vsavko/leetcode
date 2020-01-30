import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> returnArray = new ArrayList<>();
    	combinations(returnArray, new ArrayList<Integer>(), 0, 0, candidates, target);
    	return returnArray;
    }
    
    private static void combinations (List<List<Integer>> retrunArray, ArrayList<Integer> returnLsit, 
    		int sum, int candidate, int [] candidates, int target){    

    	if (sum > target) return;
    	
    	if (sum == target) {
    		retrunArray.add(new ArrayList<>(returnLsit));
    		return;
    	}
    	
    	for(int i = candidate; i < candidates.length; i++) {
    		returnLsit.add(candidates[i]);
    		combinations(retrunArray,returnLsit,sum + candidates[i], i ,candidates,target);
    		returnLsit.remove(returnLsit.size() - 1);
    	}
    }

    public static void main(String[] args) {
    	int [] arr= {1,3,2,4,5};
    	int target = 5;
		System.out.println(combinationSum(arr,target));
	}
    
}
