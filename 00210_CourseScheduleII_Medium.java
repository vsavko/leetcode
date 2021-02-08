/*There are a total of n courses you have to take labelled from 0 to n - 1.
Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
  Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
  Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= numCourses * (numCourses - 1)
prerequisites[i].length == 2
0 <= ai, bi < numCourses
ai != bi
All the pairs [ai, bi] are distinct.*/ 
class Solution {
      public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        //topological sort
        //find edges with indegree of 0
        //dfs on all children, print when no children left
        
        //This set will have edges with indegree of 0
        HashSet<Integer> indegreeSet = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            indegreeSet.add(i);
        }
        
        Stack<Integer> ans = new Stack<Integer>();
        boolean [] checked = new boolean[numCourses];
        HashMap<Integer,LinkedList<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++) {
            indegreeSet.remove(prerequisites[i][0]); //if node has input from other nodes
            if(!graph.containsKey(prerequisites[i][0])) {
                graph.put(prerequisites[i][0], new LinkedList<Integer>());
            }
            if(!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new LinkedList<Integer>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            
            //if (graph.get(prerequisites[i][0]).contains(prerequisites[i][1])) return new int 
                [0];
            
        }
        if (indegreeSet.size() == 0) return new int [0];
        
        //System.out.println(graph);
        //System.out.println(indegreeSet);
        HashSet<Integer> recursiveStack = new HashSet<>();
        for(Integer key: indegreeSet) {
            recursiveStack.add(key);
            if ( topologicalSort(key, graph, ans, checked,recursiveStack) == -1)
                return new int [0];
            recursiveStack.remove(key);
        }
        
        int [] courses = new int [numCourses]; 
        if (ans.size() < numCourses) return new int [0];
        for(int i = 0; i < numCourses; i++) {
            courses[i] = ans.pop();
        }
        
        return courses;
    }
    
    private static int topologicalSort(int key, HashMap<Integer,LinkedList<Integer>> graph,
            Stack<Integer> ans, boolean [] checked, HashSet<Integer> recursiveStack) {
        if(checked[key] == true) return 1;
        //check for cycle with recursive stack
        LinkedList<Integer> children = new LinkedList<>();
        children = graph.get(key);
        if(children != null) {
            for(Integer child: children) {
                //System.out.println("child" + child);
                //System.out.println(recursiveStack);
                if (recursiveStack.contains(child)) return -1;
                recursiveStack.add(child);
                if (topologicalSort(child,graph,ans,checked,recursiveStack) == -1)
                    return -1;
                recursiveStack.remove(child);
            }
        }
        checked[key] = true;
        ans.push(key);
        return 1;
    }
    
}
