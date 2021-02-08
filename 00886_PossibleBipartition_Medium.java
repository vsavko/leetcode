/*Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
Each person may dislike some other people, and they should not go into the same group. 
Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
Return true if and only if it is possible to split everyone into two groups in this way.
  Example 1:
Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
Output: true
Explanation: group1 [1,4], group2 [2,3]
Example 2:
Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
Output: false
Example 3:
Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
Output: false
  Constraints:
1 <= N <= 2000
0 <= dislikes.length <= 10000
dislikes[i].length == 2
1 <= dislikes[i][j] <= N
dislikes[i][0] < dislikes[i][1]
There does not exist i != j for which dislikes[i] == dislikes[j].*/ 
class Solution {
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length <=1) return true;
        HashMap<Integer,Stack<Integer>> hm = new HashMap<>();
        for(int i = 0; i < dislikes.length; i++) {
            if(!hm.containsKey(dislikes[i][0]))
                hm.put(dislikes[i][0], new Stack<Integer>());
            hm.get(dislikes[i][0]).add(dislikes[i][1]);
        }
        
        for (Integer key : hm.keySet()) {

            HashSet<Integer> group1, group2;
            Stack<Integer> keyStack = new Stack<Integer>();
            keyStack.add(key);
            group1 = new HashSet<>();
            group2 = new HashSet<>();
            
            while (!keyStack.isEmpty()) {
                
                int tmpKey = keyStack.pop();
                Stack<Integer> valueStack = hm.get(tmpKey);
                
                while(valueStack != null && !valueStack.isEmpty()) {
                    int tmpNum = valueStack.pop();
                    //System.out.println(key + " " + tmpNum);
                    if(!group1.contains(tmpKey) && !group2.contains(tmpNum)) {
                        group1.add(tmpNum);
                        group2.add(tmpKey);
                    }
                    else if(!group1.contains(tmpNum) && !group2.contains(tmpKey)) {
                        group1.add(tmpKey);
                        group2.add(tmpNum);
                    }
                    else return false;
                    keyStack.add(tmpNum);
                }
            }
        }
        
        return true;
    }

}
