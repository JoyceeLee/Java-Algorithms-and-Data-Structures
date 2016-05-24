/**
* Reverse a singly linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        
        ListNode tmp = null;
        while (pre.next != end) {
            tmp = pre.next;
            pre.next = pre.next.next;
            tmp.next = end.next;
            end.next = tmp;
        }
        return pre.next;
    }
}
