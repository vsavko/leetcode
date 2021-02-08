/*Given an array of integers arr, you are initially positioned at the first index of the array.
In one step you can jump from index i to index:
i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.
Notice that you can not jump outside of the array at any time.
  Example 1:
Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
Output: 3
Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:
Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You don't need to jump.
Example 3:
Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
Example 4:
Input: arr = [6,1,9]
Output: 2
Example 5:
Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
Output: 3
  Constraints:
1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108*/ 
class Solution {
    public int minJumps(int[] arr) {
        //bfs
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //map of array values
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i],new ArrayList<Integer>());
            map.get(arr[i]).add(i);
        }
        stack.push(0); //array positions
        boolean [] visited = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            Stack<Integer> stack2 = new Stack<>();
            while(!stack.isEmpty()){
                int tmp = stack.pop();
                if(tmp == arr.length -1) return i;
                
                
                if(tmp>0){
                    if (!visited[tmp-1])
                        stack2.push(tmp-1);
                }
                if(tmp<arr.length-1){
                    if (!visited[tmp+1] )
                        stack2.push(tmp+1);
                }
                //System.out.println(Arrays.toString(visited));
                //System.out.println(stack2);
                if(visited[tmp] == false){
                    //System.out.println("test");
                    for(Integer num: map.get(arr[tmp])){
                        if(num != i )
                            stack2.push(num);
                        visited[num] = true;
                    }
                }
                //System.out.println(stack2);
                
                    
                visited[tmp] = true;

            }
            stack = stack2;
            //System.out.println(Arrays.toString(visited));
            //System.out.println(stack);
        }
        return arr.length-1;
    }
}
