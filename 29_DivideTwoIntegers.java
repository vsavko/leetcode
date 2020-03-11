package leetcode;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
    	int divisorBits = 0;
    	int tmp = dividend;
    	int dividendBits = 0; 
    	
    	while(tmp > 0) {
    		++dividendBits;
    		tmp = tmp >> 1;
    	}
    	
    	tmp = divisor;
    	while(tmp > 0) {
    		++divisorBits;
    		tmp = tmp >> 1;
    	}
    	
    	if (divisor > dividend ) return 0;
    	int bitShift = dividendBits - divisorBits, tmpDividendbits = divisorBits;
    	int tmpDividend = dividend >> (dividendBits - divisorBits);
    	int ans = 0;
    	
        while(dividend >= divisor ) {
        	
        	while(tmpDividend < divisor) {
        		
        		//System.out.println("test " + dividend);
        		++tmpDividendbits;
        		tmpDividend = dividend >> (bitShift - 1) ;
        		ans = ans << 1;
        		++bitShift;
        	}
        	
        	if(tmpDividend >= divisor) {
        		ans = ans << 1;
        		ans |= 1;
        		tmpDividend -= divisor;
        		int mask = ~(~0 << (dividendBits - tmpDividendbits ));

        		dividend =  (tmpDividend << (dividendBits - tmpDividendbits)) + (dividend & mask);
        		
           		while( dividend == 0 && dividendBits > tmpDividendbits) { //check for remaining zeros
           			System.out.println(dividendBits);
	    			ans = ans << 1;
	    			--dividendBits;
           		}

        		dividendBits = 0;
        		tmp = dividend;
        		
            	while(tmp > 0) {
            		++dividendBits;
            		tmp = tmp >> 1;
            	}
            	
            	tmp = tmpDividend;	
            	tmpDividendbits = 0;
            	while(tmp > 0) {
            		++tmpDividendbits;
            		tmp = tmp >> 1;
            	}
            	bitShift = tmpDividendbits;
            	++tmpDividendbits;
        	}
        	
        	System.out.println("dividend " + Integer.toBinaryString(dividend) + " ans " + ans + " tmpDividend " + tmpDividend);
        }
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(divide(25,10));
	}
}
