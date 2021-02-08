/*Given a string s, consider all duplicated substrings: (contiguous) substrings of s that occur 2 or more times. The occurrences may overlap.
Return any duplicated substring that has the longest possible length. If s does not have a duplicated substring, the answer is "".
  Example 1:
Input: s = "banana"
Output: "ana"
Example 2:
Input: s = "abcd"
Output: ""
  Constraints:
2 <= s.length <= 3 * 104
s consists of lowercase English letters.*/ 
class Solution {
    public static String longestDupSubstring(String S) {
        //Set<String> substrings = new HashSet<>();
        char [] arr = S.toCharArray();
        String outString ="";
        long prime = Long.MAX_VALUE/26;
        int maxLinked = 0;
        
        int startLen = 1, endLEn = S.length()-1, midLen;
        
        while(startLen<=endLEn) {
            midLen = (startLen + endLEn)/2;
            //System.out.println(midLen);
            boolean contains = false;
            long hashNum = 0;
            HashMap<Long,LinkedList<Integer>> hm = new HashMap<>();
            //System.out.println(midLen);
            long power =1;
            for(int i = 0; i < S.length() && contains== false; i++) {   
                if(i < midLen) {
                    //hashNum =  ((hashNum*29)%prime + (S.charAt(i)-'a')) % prime;
                    //hashNum=(29*hashNum + (S.charAt(i))) % prime;
                    
                    hashNum=((25 * hashNum)  + (S.charAt(i)-'a')) % prime;
                    power = (power * 25) % prime;
                }
                else {
                    //remove top integer
                    //hashNum -=  ((S.charAt(i-midLen)-'a') *power) % prime;
                    //hashNum = (hashNum*29) % prime + (S.charAt(i)-'a');
                    hashNum=(hashNum*25+(S.charAt(i)-'a' )-((S.charAt(i-midLen)-'a')*power
                        ))%prime; 
                    
                    
                    // hash=(hash*26+(s.charAt(i+mid)-'a')-((s.charAt(i)-'a')*p))%mod; 
                     
                    if(hashNum < 0) hashNum += prime; 
                }
          
                
                
                if(i >= midLen -1) {

                    if(!hm.containsKey(hashNum))
                        hm.put(hashNum,new LinkedList<Integer>());
                    else {
                        List<Integer> list = hm.get(hashNum);
                        if(maxLinked < list.size()) maxLinked = list.size();
                        outString = new String(arr,i - midLen + 1,midLen);
                        contains= true;
                        hm.get(hashNum).add(i-midLen+1);
                        break;
                        
                        //System.out.println(sub);
                        /*for(Integer key: list) {
                            boolean isSubstring = true;
                            //comapre substrings with equal hashmaps
                            for(int j = 0; j < midLen; j++) {
                                if(S.charAt(key+j) != S.charAt(i - midLen + 1 + j)) {
                                    isSubstring = false;
                                    break;
                                }
                            }
                            
                            if(isSubstring) {
                                outString = new String(arr,key,midLen);
                                contains= true;
                                break;
                            }

                        }*/
                    }
                    
                }
            }
            
            if (contains == true) {
                startLen = midLen +1;
            }
            else endLEn = midLen -1;
        }
        //System.out.println("maxLinked" + maxLinked);
        return outString;
    }
    
}
