public static String longestPalindrome(String s) {
    	//iterate trough string array 
    	//for every iteration go max left and same right checking for palindrome
    	char [] stringArray =  s.toCharArray();
    	if (stringArray.length == 0) return "";
    	int maxlength = 0, minX=0, maxY=0, finalX = 0, finalY =0;
    	for (int i =0; i < stringArray.length; i++) {
    		//check odd then even
    		for (int z =0; z < 2; z++) {
				int y = i;
				int x = i - z;				
	    		while(x >= 0 && y < stringArray.length) {
	    			if (stringArray[x] == stringArray[y]) {
	    				minX = x--;
	    				maxY = y++;
	    			}
	    			else
	    				break;
	    		}
	    		if (maxY - minX > maxlength) {
	    			maxlength = maxY - minX;
	    			finalX = minX;
	    			finalY = maxY;
	    		}
    		}

    	}
        return s.substring(finalX,finalY+1);
    }
