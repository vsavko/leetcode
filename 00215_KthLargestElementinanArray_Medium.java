/*Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Example 1:
Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:
Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.*/ 
class Solution {
    public static int findKthLargest(int [] nums, int k) {
        quickSort(nums, 0, nums.length -1, k);
        return nums[nums.length-k];
    }
        
    private static void randomiseArray(int [] arr) {
        int pos =0;
        for(int i = arr.length; i > 0; i--) {
            int rnd = (int) (Math.random() * i);
            //System.out.println(rnd + " " + " " + pos + " " + (pos +rnd));
            swap(arr, pos, pos +rnd);
            pos++;
        }
    }
    
    public static void quickSort(int [] nums, int start, int end, int k) {
        //System.out.println("---------------");
        //System.out.println(start + " " + end);
        //System.out.println(Arrays.toString(nums));
        if(start >= end) return;
        int rnd = start  + (int) ( Math.random() * (end - start ));
        int pivot = nums[rnd];
        int left = start + 1;
        int right = end;
        //System.out.println("left " + left + " right " + right + " pivot " + pivot) ;
        swap(nums, start, rnd);
        
        while(left < right) {
            while(left < end && nums[left] < pivot) left++;
            while(right > start && nums[right] >= pivot) right--;
            
            if( left < right && nums[right] < nums[left])
                swap(nums, left, right);
        }
        
        //System.out.println("start " + start + " left " + left + " right " + right);
        if(right > start && nums[start] > nums[right])
        swap(nums, start, right);
        //System.out.println(Arrays.toString(nums));
        
        if (nums.length - k <= right-1)
            quickSort(nums, start, right-1, k);
        else if (nums.length - k >= left)
            quickSort(nums, left, end, k);
    }
    
    private static void swap(int [] nums, int v1, int v2) {
        int tmp = nums[v1];
        nums[v1] = nums[v2];
        nums[v2] = tmp;
    }
    
}
