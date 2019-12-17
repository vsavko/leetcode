/*Implement pow(x, n), which calculates x raised to the power n (xn).*/

public class Pow {
	
    public static double myPow(double x, int n) {
    	double ans = 1;
    	boolean sign = false;
    	if (n < 0) {
    		n *= -1;
    		sign = true;
    	}

        for (int i = 0; i < 32; i++) {
        	if (((n >>> i) & 1) == 1) {
        		double temp = x;
        		for(int j = 0 ; j < i; j++) {
        			temp *= temp;
        		}
        		ans *= temp;
        	}
        }
        if (sign) ans = 1/ans;
        return ans;
    }
    
    public static void main(String[] args) {
   	
    	System.out.println(myPow(3,5));

	}
}
