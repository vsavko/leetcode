/*Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.
  Example 1:
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Example 2:
Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
  Constraints:
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109*/ 
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums3 = new int[m];
        java.lang.System.arraycopy(nums1,0,nums3,0,m);
        //System.out.println(Arrays.toString(nums3));
        for(int t = 0, k = 0, i = 0; t < nums3.length || k < nums2.length;){
            if (t < nums3.length && k < nums2.length){
                if(nums3[t] < nums2[k]){
                    nums1[i++] = nums3[t++]; 
                }
                else{
                    nums1[i++] = nums2[k++]; 
                }   
            }
            else if(t < nums3.length){
                nums1[i++] = nums3[t++]; 
            }
            else if(k < nums2.length){
                nums1[i++] = nums2[k++];  
            }
        }
    }
}
