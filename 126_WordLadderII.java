/*Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.*/


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadderII {
	
	class FatherNode {
		FatherNode node;
		String word;
		
		public FatherNode(FatherNode node, String word) {
			this.node = node;
			this.word = word;
		}
	}

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	
    	LinkedList<String> usedWords = new LinkedList<>();
    	HashMap<String,Integer> map = new HashMap<>();
    	
    	for(String key: wordList) {
    		map.put(key,0);
    	}
    	map.put(beginWord,0);
    	
	    LinkedList<List<String>> ladder = new LinkedList<>();
	    if (!map.containsKey(endWord)) return ladder;
	    
		Queue<FatherNode> queue = new LinkedList<>();
		Queue<FatherNode> tempQueue = new LinkedList<>();
		queue.add(new FatherNode(null,endWord));
		boolean found = false;
		while(!queue.isEmpty()){
			FatherNode fatherNode = queue.remove();
		    String word = new String(fatherNode.word);
		    if(word.equals(beginWord)) {
		    	found = true;
		    	LinkedList<String> tmpList = new LinkedList<>();
		    	while(fatherNode!= null) {
		    		tmpList.add(fatherNode.word);
		    		fatherNode = fatherNode.node;
		    	}

		    	ladder.add(tmpList);
		    	
		    }
		    
		    //do not add new elements to the queue but check if any of the remaining ones also match
		    if (found == true ) continue;
		    
		    int count = 0;
		    while( count < word.length()) {
		    	StringBuilder tmp = new StringBuilder(word);

		        for(char i = 'a'; i <= 'z'; i++){
		            tmp.setCharAt(count, i);
		            String tmp2 = tmp.toString();
		            if (map.containsKey(tmp2)) {
		            	usedWords.add(tmp2);
		            	FatherNode tmpNode = new FatherNode(fatherNode,tmp2);
		            	tempQueue.add(tmpNode);
		            }
		        }   
		        ++count;
		    }

		    if(queue.isEmpty()) {
		    	for(String key: usedWords) {
		    		map.remove(key);
		    	}
		    	
		    	usedWords = new LinkedList<>();
		    	queue = tempQueue;
		    	tempQueue = new LinkedList<>();
		    }

		}
		return ladder;
	}
    
    public static void main(String[] args) {
    	String begin = "hit";;
    	String end = "cog";
    	LinkedList<String> words= new LinkedList<>();
    	words.add("hot");
    	words.add("dot");
    	words.add("dog");
    	words.add("lot");
    	words.add("log");
    	words.add("cog");
    	WordLadderII wl = new WordLadderII();
    	System.out.println(wl.findLadders(begin, end, words));

	}
}
