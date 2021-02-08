/*Given a string, sort it in decreasing order based on the frequency of characters.
Example 1:
Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:
Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.*/ 
class Solution {
    public static String frequencySort(String s) {
        int [][] characters = new int [256][2];
        for(int i = 0; i < 256; i++) {
            characters[i][0] = i;
        }
        for(int i = 0; i < s.length(); i++) {
            characters[s.charAt(i)][1] += 1;
        }
        //System.out.println(Arrays.deepToString(characters));  
        int max = 1, z = 0;
        char [] ans = new char [s.length()];

        while (max > 0) {
            max = 0;
            int maxLetter = 0;
            for(int i = 0; i < characters.length; i++) {
                if(characters[i][1] > max) {
                    max = characters[i][1];
                    maxLetter = characters[i][0];
                }
            }
            
            
            for(int i = 0; i < characters[maxLetter][1]; i++) {
                ans[z++] = (char)characters[maxLetter][0];
            }
            characters[maxLetter][1]= 0;
        }
            
        //System.out.println(Arrays.toString(ans));
        
       // return Str.toString();
        return new String(ans);
    }
}
