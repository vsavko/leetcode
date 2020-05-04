import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
        	set.add(nums[i]);
        	if (nums[i] > 0 && nums[i] < min) //find min pos int
        		min = nums[i];
        }
        
        if(min > 1) return 1;
        
        while(true) {
        	if(!set.contains(++min))
        		return min;
        }
    }
    
    public static void main(String[] args) {
		int [] arr1 = {1,2,0};
		int [] arr2 = {3,4,-1,1};
		int [] arr3 = {7,8,9,11,12};
		FirstMissingPositive fmp = new FirstMissingPositive();
		System.out.println(fmp.firstMissingPositive(arr1));
		System.out.println(fmp.firstMissingPositive(arr2));
		System.out.println(fmp.firstMissingPositive(arr3));
	}
}
