/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I*/ 
 
 public static String convert(String s, int numRows) {
    	int len = s.length();
    	if (len == 0 || numRows == 0) return "";
    	String outString = "";
    	int blockSize = 2*numRows-2; //number of characters in 1 "zig-zag" block
        for (int rowNum=0; rowNum < numRows; rowNum++) {
        	int j = rowNum;
        	//read first and last row
        	if(rowNum == 0 || rowNum == numRows-1) {
        		while(j < len) {
        			outString += s.charAt(j);
        			j += Math.max(1, blockSize);
        		}
        	}
        	else {
        		while(j < len) {
        			outString += s.charAt(j); //take char from whole column
        			if (j + blockSize - 2*rowNum >= len)
        				break;
        			outString += s.charAt(j + blockSize - 2*rowNum); //take char from "zig-zaged" column
        			j +=  blockSize;
        		}
        	}
        }

        return outString;
    }
