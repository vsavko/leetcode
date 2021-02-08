/*You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
Example:
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/ 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newList1 = new ListNode();
        ListNode newList2 = new ListNode();
        int l1Count = 0;
        int l2Count = 0;
        
        while(l1 != null){
            ListNode nodeCopy = new ListNode(l1.val);
            nodeCopy.next = newList1.next;
            newList1.next = nodeCopy;
            l1 = l1.next;
            ++l1Count;
        }
        while(l2 != null){
            ListNode nodeCopy = new ListNode(l2.val);
            nodeCopy.next = newList2.next;
            newList2.next = nodeCopy;
            l2 = l2.next;
            ++l2Count;
        }
        
        ListNode newList3 = null;
        int count = 0;
        if (l1Count >= l2Count){
            newList3 = newList1.next;
            newList2 = newList2.next;
            count = l1Count;
        }
        else{
            newList3 = newList2.next;
            newList2 = newList1.next;
            count = l2Count;
        }
        
        int nexDigit = 0;
        ListNode ans = newList3;
        for(int i = 0; i < count; i++){
            int newList2Val = 0 ;
            if(newList2 != null) 
                newList2Val = newList2.val;
            
            int tmp = nexDigit + newList3.val + newList2Val;
            //System.out.println("nexDigit " + nexDigit + " " + newList3.val + " " + 
                newList2Val);
            if (tmp > 9){
                nexDigit = 1;
                newList3.val = tmp -10;
            }
            else{
                nexDigit = 0;
                newList3.val = tmp;
            }
            if(newList3.next != null)
            newList3 = newList3.next;
            if(newList2 != null) 
                newList2 = newList2.next;
        }
        
        if (nexDigit > 0) {
            newList3.next = new ListNode(1);
        }
        

        
        ListNode previous = null;
        ListNode next = ans;
        while(next != null){
            ans = next;
            next = ans.next;
            ans.next = previous;
            previous = ans;
        }
        

       /* ListNode tmpnode = ans;
        while(tmpnode != null) {
            System.out.println(tmpnode.val);
            tmpnode = tmpnode.next;
        }
        System.out.println();*/
        
        return ans;
        
    }
    
}
