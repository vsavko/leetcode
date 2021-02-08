/*Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
  Example 1:
Input: n = 12
Output: 21
Example 2:
Input: n = 21
Output: -1
  Constraints:
1 <= n <= 231 - 1*/ 
class Solution {
        char[] maxNum = ("" + Integer.MAX_VALUE).toCharArray();
    
    public int nextGreaterElement(int n) {
    
       char[] nChr = ("" + n).toCharArray();
       int digit = compareWithIntMax(nChr);
       if (digit == 0) return -1;
       
       
       int [] haveDigits = new int[10]; //records position of digit
       Arrays.fill(haveDigits, -1);
       
       for(int i = 0; i <= digit && i < nChr.length ; i++) {
           int j = nChr.length -1 - i;
           //System.out.println(" i " + i + " j " + j + " " + digit + "nChr[j] " + nChr[j]);
           if(i < digit) {
               //System.out.println(Arrays.toString(haveDigits));
               for(int z = nChr[j] - '0' +1; z <= 9 ; z++) {
                   //System.out.println("z " + z);
                   if(haveDigits[z] > -1 ) {
                       //System.out.println("test");
                       nChr[haveDigits[z]] = nChr[j];
                       nChr[j] = (char) ( z + '0');
                       //System.out.println(nChr);
                       return Integer.parseInt(sortPartDesc(nChr, j));
                       //swap return
                   }
               }
           }
           else {

               //i is the last availible digit it should be less or equal to the maxNum after 
                   swapping
               for(int z = nChr[j] - '0' +1; z <= maxNum[j] - '0' ; z++) {
                   
                   if(haveDigits[z] > -1 ) {
                       //System.out.println("test");
                       nChr[haveDigits[z]] = nChr[j];
                       nChr[j] = (char) ( z + '0');
                       //System.out.println(nChr);
                       return  Integer.parseInt(sortPartDesc(nChr, j));
                       //swap return
                   }
               }
           }
           haveDigits[nChr[j] - '0'] = j;
       }
       
       return -1;
        
    }
    
    private int compareWithIntMax(char [] num) {
        if (maxNum.length > num.length) return maxNum.length;
        for(int i = 0; i < maxNum.length; i++) {
            if (maxNum[i] > num[i]) {
                return maxNum.length - i - 1;
            }
        }
        return 0;
    }
    
    private String sortPartDesc(char [] arr, int j) {
        //System.out.println(Arrays.toString(arr));
        
           String tmp = new String(arr, 0 , j+1);
           String tmp2 = new String(arr, j+1 , arr.length - j-1);
           
           char [] tmpChr = tmp2.toCharArray();
           
          // System.out.println(Arrays.toString(tmpChr));
           Arrays.sort(tmpChr);
           //System.out.println(Arrays.toString(tmpChr));
           tmp2 = new String(tmpChr);

          // System.out.println(tmp + " " + tmp2);
           return tmp+tmp2;
           
    }
}
