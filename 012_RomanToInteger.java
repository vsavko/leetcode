/*Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.*/


public class Roman {
	

    public static String intToRoman(int num) {
    	Stack<String> stack = new Stack<>();
        int temp = num, divTemp, i = 0;
        String var1 = "", var2 = "", var3 = "", returnString = "";
        
        while (temp != 0) {
        	switch(i++) {
        		case(0):
        			var1 = "I";
        			var2 = "V";
        			var3 = "X";
        			break;
        		case(1):
        			var1 = "X";
    				var2 = "L";
    				var3 = "C";
        			break;
        		case(2):
        			var1 = "C";
    				var2 = "D";
    				var3 = "M";
        			break;
        		case(3):
        			var1 = "M";
        			break;
        	}

	        divTemp = temp % 10;
	        temp /= 10;
	        if(divTemp != 0) {
	        	switch(divTemp) {
	        	case(1): stack.add(var1); break;
	        	case(2): stack.add(var1+var1); break;
	        	case(3): stack.add(var1+var1+var1); break;
	        	case(4): stack.add(var1+var2); break;
	        	case(5): stack.add(var2); break;
	        	case(6): stack.add(var2 + var1); break;
	        	case(7): stack.add(var2 + var1 + var1); break;
	        	case(8): stack.add(var2 + var1 + var1 + var1); break;
	        	case(9): stack.add(var1+var3); break;
	        	}
	        }
        }
        
        while (!stack.empty()) {
        	returnString += stack.pop();
        }
        
        return returnString;
        
    }

	public static void main(String[] args) {
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(58));
		System.out.println(intToRoman(1994));

	}

}
