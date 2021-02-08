/*You want to form a target string of lowercase letters.
At the beginning, your sequence is target.length '?' marks.  You also have a stamp of lowercase letters.
On each turn, you may place the stamp over the sequence, and replace every letter in the sequence with the corresponding letter from the stamp.  You can make up to 10 * target.length turns.
For example, if the initial sequence is "?????", and your stamp is "abc",  then you may make "abc??", "?abc?", "??abc" in the first turn.  (Note that the stamp must be fully contained in the boundaries of the sequence in order to stamp.)
If the sequence is possible to stamp, then return an array of the index of the left-most letter being stamped at each turn.  If the sequence is not possible to stamp, return an empty array.
For example, if the sequence is "ababc", and the stamp is "abc", then we could return the answer [0, 2], corresponding to the moves "?????" -> "abc??" -> "ababc".
Also, if the sequence is possible to stamp, it is guaranteed it is possible to stamp within 10 * target.length moves.  Any answers specifying more than this number of moves will not be accepted.
  Example 1:
Input: stamp = "abc", target = "ababc"
Output: [0,2]
([1,0,2] would also be accepted as an answer, as well as some other answers.)
Example 2:
Input: stamp = "abca", target = "aabcaca"
Output: [3,0,1]
  Note:
1 <= stamp.length <= target.length <= 1000
stamp and target only contain lowercase letters.*/ 
class Solution {
    
    public int[] movesToStamp(String stamp, String target) {
        ArrayList<Integer> lst = prefixString(stamp, target);
        int[] arr = new int[0];
        if (lst == null) return arr;
        arr = lst
                .stream()
                .mapToInt(i -> i)
                .toArray();
        return arr;
        }
    
    
    private ArrayList<Integer> prefixString(String stamp, String target) {
        boolean hasFullWord = false;
        ArrayList<Integer> ans = new ArrayList<>();
        //start with trying to prefix a full word
        //move by 1 character if doesnt match
        //move by a full word if does
        
        int beginIndex = target.length()-stamp.length();
        int endIndex = target.length();
        int startOfLastWord = target.length()+1;
        
        StringBuilder newTarget = new StringBuilder(target);
        
        while(endIndex > 0) {
             //when we go to the left of target
            if(beginIndex < 0) beginIndex = 0;
            String sub = target.substring(beginIndex, endIndex);

            if (sub.equals(stamp.substring(0, endIndex-beginIndex))) {
                startOfLastWord = beginIndex;
                ans.add(0,beginIndex);
                for (int i = beginIndex; i < endIndex; i++) {
                    newTarget.setCharAt(i, '*');
                }
                endIndex = beginIndex;
                beginIndex -= stamp.length();
                
            }
            else {
                
                ++beginIndex;
                if (beginIndex + stamp.length() > endIndex &&  endIndex < startOfLastWord) 
                    {
                    --endIndex;
                    beginIndex = endIndex - stamp.length();
                    if(beginIndex < 0) break;
                }
                
                if (beginIndex > target.length() - stamp.length() || beginIndex == endIndex
                    ) {
                    --endIndex;
                    beginIndex = endIndex - stamp.length();
                }   
            }
        }
        
        ArrayList<Integer> tmp  = postifxString(stamp, newTarget);
        if (tmp == null) 
            return null;
        tmp.addAll(ans); 
        return tmp;
    }
    
   
    private ArrayList<Integer> postifxString(String stamp, StringBuilder target){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean prevStam = false;
        for (int i = 0; i <= target.length() - stamp.length(); i++) {
            if (prevStam == true && target.charAt(i + stamp.length()-1) == '*')
                continue;
            boolean stampCorrect = true;
            boolean writeAns = false;
            for(int j = 0; j < stamp.length(); j++) {
                
                if(target.charAt(i+j) != '*') {
                    if (target.charAt(i+j) != stamp.charAt(j)) {
                        stampCorrect = false;
                        prevStam= false;
                        break;
                    }
                    writeAns = true; //not all ***
                }
            }
            if(stampCorrect == true)
                prevStam = true;
            if (stampCorrect && writeAns) {
                ans.add(0, i);
                for(int j = 0; j < stamp.length(); j++) {
                    target.setCharAt(i+j,'*');
                }
            }
            if (target.charAt(i) != '*')
                return null;
        }
        for(int i = target.length()-1; i >= target.length()-stamp.length(); i--) {
            if (target.charAt(i) != '*')
                return null;
        }
        
        return ans;

