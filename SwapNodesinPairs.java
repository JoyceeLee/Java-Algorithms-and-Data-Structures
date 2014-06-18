/**
* Given a linked list, swap every two adjacent nodes and return its head.
* 
* For example,
* Given 1->2->3->4, you should return the list as 2->1->4->3.
* 
* Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

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
    public ListNode swapPairs(ListNode head) {
      if(head==null || head.next==null) return head;
      ListNode tmp = head.next;
      head.next = swapPairs(tmp.next);
      tmp.next = head;
      return tmp;
    }
}

public class Solution {
    public ListNode swapPairs(ListNode head) {
      ListNode preHead = new ListNode(-1);
      preHead.next = head;
      ListNode pre = preHead;
      while(head!=null && head.next!=null) {
        pre.next = head.next;
        head.next = head.next.next;
        pre.next.next = head;
        pre = pre.next.next;
        head = head.next;
      }
      return preHead.next;
    }
}
