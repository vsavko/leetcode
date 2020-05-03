class JumpGameII {
        public int jump(int[] nums) {
        //make a dp table
    	//go from the end, if we can reach end, put 1 for that position and 
    	//go to next position
    	//if less then 1 move, apply greedy tactics and stop if 2 moves
    	int [] dp = new int[nums.length];
    	
    	for(int i = nums.length-2; i >= 0 ; i--) {
    		int movesToFinish = nums.length - 1 - i;
    		if(nums[i] >= movesToFinish) { 
    				dp[i] = 1;
    				continue;
    		}
    		else {
    			int minMoves = nums.length;
    			dp[i] = minMoves;
    			for(int j = nums[i]; j > 0; j--) {
    				if (dp[i+j] == 1) { dp[i] = 2;
    					break;
    				}
    				else {
    					if(minMoves > dp[i+j] + 1) {
    						minMoves = dp[i+j] + 1;
    						dp[i] = minMoves;
    					}
    				}
    			}
    		}			
    	}
    	System.out.println(Arrays.toString(dp));
    	return dp[0];
    }
    
}
