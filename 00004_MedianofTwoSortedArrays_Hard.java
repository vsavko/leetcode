/*Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
Follow up: The overall run time complexity should be O(log (m+n)).
  Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:
Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:
Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:
Input: nums1 = [2], nums2 = []
Output: 2.00000
  Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106*/ 
class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int [] nums3 = new int [nums1.length + nums2.length];
            int z = 0, i =0, j = 0;
            double median;
            while(i < nums1.length || j < nums2.length){
                
                if (i == nums1.length){
                    nums3[z++] = nums2[j++];
                    continue;
                }
                
                if (j == nums2.length){
                    nums3[z++] = nums1[i++];
                    continue;
                }
                
                if (nums1[i] > nums2[j])
                    nums3[z++]= nums2[j++];
                else
                    nums3[z++]= nums1[i++];
            }
            
            if ((nums1.length + nums2.length) % 2 == 0) {
                int num = (int)(nums1.length + nums2.length - 1) /2;
                median = (double)(nums3[num] + nums3[num+1])/2;
            }
            else {
                median = (double)nums3[(nums1.length + nums2.length -1) / 2];
            }
                        
            return median;
        }
}
