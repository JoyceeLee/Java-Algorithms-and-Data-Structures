// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode prehead = new ListNode(-1);
      ListNode run = prehead;
      while(l1!=null && l2!=null) {
        if(l1.val<=l2.val) {
          run.next = l1;
          l1 = l1.next;
        } else {
          run.next = l2;
          l2 = l2.next;
        }
        run = run.next;
      }
      if(l1!=null) {
        run.next = l1;
      } else {
        run.next = l2;
      }
      return prehead.next;
    }
}
