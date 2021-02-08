/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.
  Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:
Input: lists = []
Output: []
Example 3:
Input: lists = [[]]
Output: []
  Constraints:
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.*/ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
       
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


}
