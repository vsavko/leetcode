public static int reverse(int x) {
        int y = 0;
        int sign = (x < 0) ? -1 : 1;
        int leftover = Math.abs(x);
        int nr_of_digits = 0;
        int digit = 0;
        int max = Integer.MAX_VALUE;
        boolean check = false;
        
        int [] minInt = new int [10];
        int [] maxInt = new int [10];
        
        for(int i = 0; i < 10; i++) {
        	minInt[i] = max % 10;
        	maxInt[i] = max % 10;
        	max /= 10;
        }
        minInt[0] += 1;
        
        
        while (leftover > 0) {
        	leftover /= 10;
        	++nr_of_digits;
        }
        
    	//check overflow
    	if (nr_of_digits > 10) {
    		return 0;
    	}
    	
    	if (nr_of_digits == 10)
    		check = true;
    	
 
        leftover = Math.abs(x);  
        while (nr_of_digits > 0) {
        	
        	digit = leftover % 10;

        	//check overflow
        	if (check == true) {	
        		if(digit < maxInt[nr_of_digits-1] || digit < minInt[nr_of_digits-1]) {
        			check = false;
        		}
        		
        		if (x > 0 && digit > maxInt[nr_of_digits-1]){
        			return 0;
        		}
        		else if(digit > minInt[nr_of_digits-1]) {
        			return 0;
        		}
        	}

        	y += digit *(int)Math.pow(10, nr_of_digits-- -1);
        	leftover /= 10;
        }

        return (sign * y);
    }
