/*Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. 
Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraphDFS {
	
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	private ArrayList<Integer> checkedNodes = new ArrayList<>();
	private HashMap<Integer,Node> graphMemory = new HashMap<>();

    public Node cloneGraph(Node node) {
    	return DFS(node);
    }
	
	public Node DFS(Node nodeInput) {
		if (!checkedNodes.contains(nodeInput.val)) {
			List<Node> neighbors = new ArrayList<>();
			if (!graphMemory.containsKey(nodeInput.val))
				graphMemory.put(nodeInput.val, new Node());
			checkedNodes.add(nodeInput.val);
			for (Node key: nodeInput.neighbors) {
				DFS(key);
				neighbors.add(graphMemory.get(key.val));
			}
			graphMemory.get(nodeInput.val).neighbors = neighbors;
			graphMemory.get(nodeInput.val).val = nodeInput.val;
		}
		return graphMemory.get(nodeInput.val);
	}

}
