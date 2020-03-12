package test;

public class DivideTwoIntegers2 {
	 public static int divide(int dividend, int divisor) {
		 	if (divisor == 0) throw new IllegalArgumentException("Cannot divide by 0!");
		 	int signNum = Integer.signum(dividend) * Integer.signum(divisor);

		 	dividend = Math.abs(dividend);
		 	divisor = Math.abs(divisor);

		 	if ((divisor > dividend && dividend != Integer.MIN_VALUE )|| dividend == 0) return 0;

		 	int divisorBits = 0;
	    	int dividendBits = 0; 
	    	int leftBits, ans = 0;
	    	
	    	int tmp = dividend;
	    	while(tmp != 0) {
	    		++dividendBits;
	    		tmp = tmp >>> 1;
	    	}
	    	
	    	tmp = divisor;
	    	while(tmp != 0) {
	    		++divisorBits;
	    		tmp = tmp >>> 1;
	    	}
	    	if (dividendBits == divisorBits ) return 1*signNum; //make sure leftBits > 0
	    	leftBits = dividendBits - divisorBits;
	    	
	    	int tempDividend = dividend >>> (dividendBits - divisorBits);
	    	boolean addNext = false;

	    	while(leftBits> 0) {
	    		if(tempDividend < divisor) {
	    			--leftBits;
	    			if (addNext == true) addNext = false;
	    			else ans <<= 1;
	    			tempDividend <<= 1;
	    			int mask = 1 << leftBits ; // extract next bit from dividend
	    			tempDividend |= (dividend & mask) >> (leftBits); // add next bit to temp dividend
	    			
	    		}

	    		if (tempDividend >= divisor || tempDividend == Integer.MIN_VALUE){
	    			ans <<= 1;
	    			ans |= 1;
	    			tempDividend = tempDividend - divisor;
	    			addNext = true;
	    		}
	    		else if (leftBits == 0) { //remove last bit from dividend
	    			ans <<= 1;
	    		}
	    	}
	    	
	    	if (ans == Integer.MIN_VALUE) {
	    		if(signNum > 0) ans = Integer.MAX_VALUE;
	    	}
	    	
	    	return ans*signNum;
	 }
	 
	 public static void main(String[] args) {
		 for(int i =0; i < -2000; i--) {
			 int x1 = i / 7;
			 int x2 = divide(i,7);
			 if(x2 != x1)
				 System.out.println(i + " " + x2 + " " + x1);
		 }
		 int x = Integer.MIN_VALUE;
		 int x2 = Integer.MAX_VALUE;
		 
		 System.out.println(x/x2);
		 System.out.println(divide(x,x2));
		 
		 x = -535;
		 x2 = Integer.MIN_VALUE;
		 
		 System.out.println(x/x2);
		 System.out.println(divide(x,x2));

	}
}
