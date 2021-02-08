/*Given a non-empty array of unique positive integers A, consider the following graph:
There are A.length nodes, labelled A[0] to A[A.length - 1];
There is an edge between A[i] and A[j] if and only if A[i] and A[j] share a common factor greater than 1.
Return the size of the largest connected component in the graph.
  Example 1:
Input: [4,6,15,35]
Output: 4
Example 2:
Input: [20,50,9,63]
Output: 2
Example 3:
Input: [2,3,6,7,4,12,21,39]
Output: 8
Note:
1 <= A.length <= 20000
1 <= A[i] <= 100000*/ 
class Solution {
    private static final int HashMap = 0;
    int [] uf;
    
    int find (int num) {
        if (uf[num] == num)
            return num;
        else 
            uf[num] = find(uf[num]);
        return uf[num];
    }
            
    void union(int num1, int num2) {
        uf[find(num1)] = uf[find(num2)];
    }
    
    public int largestComponentSize(int[] A) {
        
        //make a prime table
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            if (A[i] > max) 
                max = A[i];
        }
        
        uf = new int[max+1];
        for(int i = 1; i < max+1; i++) {
            uf[i] = i;
        }
        //System.out.println(Arrays.toString(uf));
        //get prime factors
        for(int j = 0; j < A.length; j++) {
            for(int i = 2; i <= Math.sqrt(A[j]); i++) {
                if (A[j] % i == 0) {
                    union(A[j], i);
                    union(A[j], A[j]/i);
                }
            }
        }
        //System.out.println(Arrays.toString(uf));
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(Integer key: A) {
            int key1 = find(key);
            if (!map.containsKey(key1)){
                map.put(key1,0);
            }
            
            map.put(key1, map.get(key1)+1);
            if (map.get(key1) > ans)
                ans = map.get(key1);
        }
        
        //System.out.println(map);
        
        return  ans;
    }
}
