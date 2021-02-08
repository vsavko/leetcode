/*There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
Example 2:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500
Explanation: 
The graph looks like this:


The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
  Constraints:
The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
The size of flights will be in range [0, n * (n - 1) / 2].
The format of each flight will be (src, dst, price).
The price of each flight will be in the range [1, 10000].
k is in the range of [0, n - 1].
There will not be any duplicated flights or self cycles.*/ 
class Solution {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if (n == 1) return 0;
        
        //make a graph
        HashMap<Integer,HashMap<Integer,Integer>> graph = new HashMap<>();
        for(int i = 0; i < flights.length; i++) {
            if (!graph.containsKey(flights[i][0]))
                graph.put(flights[i][0], new HashMap<Integer,Integer>());
            graph.get(flights[i][0]).put(flights[i][1], flights[i][2]);
        }
        
        //BFS on k
        int k = 0;
        Stack<Integer> cities = new Stack<Integer>();
        HashMap<Integer,Integer> cityCost = new HashMap<>();
        cityCost.put(src,0);
        
        cities.add(src);
        while(k <= K ) {
            //System.out.println("k" + k);
            Stack<Integer> newCities = new Stack<Integer>();
            HashMap<Integer,Integer> newCost = new HashMap<>(cityCost);
            while(!cities.isEmpty()) {
                int city = cities.pop();
                
                if (!graph.containsKey(city))
                    continue;
                //System.out.println("city " +city);
                HashMap<Integer,Integer> hm = graph.get(city);
                //System.out.println("hm size" + hm.size());
                
                for(Integer key : hm.keySet()) {
                    
                    int pathCost = cityCost.get(city) + hm.get(key);
                    //System.out.println("from " + city + " city To " + key + " path " + 
                        pathCost);
                    
                    if (!newCost.containsKey(key)) {
                        newCost.put(key, pathCost);
                        newCities.add(key);
                    }
                    else {
                        if (pathCost < newCost.get(key)) {
                            newCost.put(key, pathCost);
                            newCities.add(key);
                        }
                    }
                    
                }
                
                
            }
            ++k;
            cityCost = newCost;
            cities = newCities;
            //System.out.println(cityCost.toString());
        }
        
        if (!cityCost.containsKey(dst)) return -1;
        return cityCost.get(dst);
    }
}
