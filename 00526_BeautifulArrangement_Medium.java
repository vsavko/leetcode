/*Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.
  Example 1:
Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
The second beautiful arrangement is [2,1]:
    - perm[1] = 2 is divisible by i = 1
    - i = 2 is divisible by perm[2] = 1
Example 2:
Input: n = 1
Output: 1
  Constraints:
1 <= n <= 15*/ 
class Solution {
    HashMap<HashSet<Integer>, Integer> combos;
    int count = 0;
    int dfsCount = 0;
    public int countArrangement(int n) {
        combos = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i =1; i <= n; i++ ) {
            set.add(i);
        }
        
        int ans = dfs(n, 1, set);
        //System.out.println("count " + count + " dfs " + dfsCount);
        return ans;
    }
    
    private int dfs(int n, int pos,  HashSet<Integer> set) {
        ++dfsCount;
        /*if(combos.containsKey(set)) {
            ++count;
            return combos.get(set);
        }*/
        if(n < pos) return 1;
        int ans = 0;
        HashSet<Integer> setCopy = new HashSet<>(set);
        for(Integer key: setCopy) {
            if(key % pos == 0 || pos % key == 0) {
                set.remove(key);
                ans += dfs(n, pos+1, set);
                set.add(key);
            }
        }
        //System.out.println(set + " " +ans);
        //combos.put(new HashSet<>(set), ans);
        return ans;
    }
}
