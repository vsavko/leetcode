/*Given two binary strings a and b, return their sum as a binary string.
  Example 1:
Input: a = "11", b = "1"
Output: "100"
Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
  Constraints:
1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.*/ 
class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;
        
        while(i >= 0 || j >= 0){
            int aNum = 0, bNum = 0;
            if (i >= 0) aNum = a.charAt(i--) - '0';
            if (j >= 0) bNum = b.charAt(j--) - '0';  
            //System.out.println(aNum + " " + bNum + " " + c );
            str.insert(0, (aNum + bNum + c) % 2);
            if (aNum + bNum + c >= 2) 
                c = 1; 
            else 
                c = 0;
        }
        
        if (c > 0) str.insert(0,1);
        
        return str.toString();
    }
}
