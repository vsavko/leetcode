package test;

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

    	//System.out.println(Integer.toBinaryString(dividend));
    	//System.out.println(dividendBits);
    	//System.out.println(divisorBits);
    	
    	if (divisor > dividend ) return 0;
    	int bitShift = dividendBits - divisorBits, tmpDividendbits = divisorBits;
    	int tmpDividend = dividend >> (dividendBits - divisorBits);
    	int ans = 0;
    	
        while(dividend > divisor) {
        	System.out.println("DIV " + Integer.toBinaryString(dividend));
        	
        	System.out.println("bitShift " + bitShift);

        	while(tmpDividend < divisor) {
        		System.out.println("test");
        		++tmpDividendbits;
        		tmpDividend = dividend >> (bitShift - 1) ;
        		ans = ans << 1;
        		++bitShift;
        	}
        	System.out.println(Integer.toBinaryString(tmpDividend));
        	
        	if(tmpDividend >= divisor) {
        		ans |= 1;
        		tmpDividend -= divisor;
        		tmpDividend = tmpDividend << (dividendBits - tmpDividendbits);
        		int mask = 1 << (dividendBits - tmpDividendbits - 1);
        		tmpDividend += dividend & mask;
        		dividend = tmpDividend;
        		
        		
        		tmp = dividend;
            	while(tmp > 0) {
            		++dividendBits;
            		tmp = tmp >> 1;
            	}
            	
        		bitShift = dividendBits - 1;
        	}
        	
        	System.out.println("dividend " + Integer.toBinaryString(dividend) + " ans " + ans);
        }
        return ans;
    }
    
    public static void main(String[] args) {
		System.out.println(divide(74,10));
	}
}
