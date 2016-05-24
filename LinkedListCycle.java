// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(true){
            fast = fast.next;
            if(fast == null)
              return false;
            if(fast == slow)
              return true;
              
            fast = fast.next;
            if(fast == null)
              return false;
            if(fast == slow)
              return true;
              
            slow = slow.next;
            if(slow == fast)
              return true;
        }
    }
}
