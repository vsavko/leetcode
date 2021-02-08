/*All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
  Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]
Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
  Constraints:
0 <= s.length <= 105
s[i] is 'A', 'C', 'G', or 'T'.*/ 
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        StringBuilder str = new StringBuilder();
        for (int i=0; i < s.length(); i++){
            str.append(s.charAt(i));
            if (i >= 9){
                if (!hm.containsKey(str.toString()))
                    hm.put(str.toString(),1);
                else
                    hm.put(str.toString(),2);
                str.deleteCharAt(0);
            }
            //System.out.println(hm);
        }
        
        List<String> ans = new LinkedList<>();
        for(Map.Entry<String, Integer> entry :  hm.entrySet()) {
            if (entry.getValue() > 1)
                ans.add(entry.getKey());
        }
        
        return ans;
    }
}
