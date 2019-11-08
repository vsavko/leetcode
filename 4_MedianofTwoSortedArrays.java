//This is done in O(n+m) time though, not O(log(n+m))
//We'd need to apply binary search to find a O(log(n+m)) solution and its quite tricky

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
