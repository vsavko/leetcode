class Solution {
    public int minDistance(String word1, String word2) {
    	if(word1.length() == 0) return word2.length();
    	if(word2.length() == 0) return word1.length();
    	
    	int [][] dp = new int[word1.length()+1][word2.length()+1];
    	//word1  - rows, word2 - cols
    	for(int y = 0; y <= word1.length(); y++ ) {
    		dp[y][0] = y;
    	}
    	
    	for(int x = 0; x <= word2.length(); x++ ) {
    		dp[0][x] = x;
    	}
    	
    	for(int y = 1; y <= word1.length(); y++) {//rows
    		for(int x = 1; x <=  word2.length(); x++) {//cols
    			int delete = dp[y][x-1] +1;
    			int insert = dp[y-1][x] + 1;
    			int replace;
    			if (word1.charAt(y-1) == word2.charAt(x-1)) 
    				replace = dp[y-1][x-1] + 0;
    			else
    				replace = dp[y-1][x-1] + 1;
    			dp[y][x] = Math.min(Math.min(delete, insert),replace);
    		}
    	}
    	

    	return dp[word1.length()][word2.length()];
    }
}
