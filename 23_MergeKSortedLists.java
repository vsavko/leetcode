/*Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6*/

public class MergeKSortedLists {

	  public class ListNode {
	      int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	  }
	  
	private static boolean isSmaller (ListNode node1, ListNode node2) {
		if (node1 == null) return false;
		else if (node2 == null) return true;
		else return(node1.val <= node2.val);
	}


	public static ListNode mergeKLists(ListNode[] lists) {
		
		if (lists == null || lists.length == 0 ) return null;
            	
    	if (lists.length < 2) return lists[0];
    	
    	ListNode firstNode = lists[0], node1, node2, currentNode;
    	
    	for(int i = 1; i < lists.length; i++) {
    		
    		if (lists[i] == null) continue;
    		if (isSmaller(lists[i],firstNode)) {
    			node2 = firstNode;
    			firstNode = lists[i];
    		}
    		else {
    			node2 = lists[i];
    		}
    		
    		currentNode = firstNode;
    		node1 = firstNode.next;

    		while(node1 != null || node2 != null) {
    			if (node1 == null) {
    				currentNode.next = node2;
    				break;
    			}
    			else if (node2 == null ) {
    				currentNode.next = node1;
    				break;
    			}
    			else {
    				if (node1.val < node2.val) {
    					currentNode.next = node1;
    					node1 = node1.next;
    				}
    				else {
     					currentNode.next = node2;
    					node2 = node2.next;
    				}
    				currentNode = currentNode.next;
    			}
    		}
	
    	}
    	return firstNode;
    	
    }

	
	public static void main(String[] args) {
		ListNode [] lists = new ListNode[2];
		
		MergeKSortedLists sl = new MergeKSortedLists();
		MergeKSortedLists.ListNode lNode = sl.new ListNode(1);
		
		lists[1] = lNode;
		
		ListNode lists2 = mergeKLists(lists);
		
		System.out.println(lists2.val);
	}

}
