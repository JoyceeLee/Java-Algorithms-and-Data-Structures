/**
* Given a singly linked list L: L0→L1→…→Ln-1→Ln,
* reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
* 
* You must do this in-place without altering the nodes' values.
* 
* For example,
* Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/


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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
            return;
        ListNode left = head;
        ListNode right = head;
        while(right.next!=null) {
            right = right.next.next;
            if(right==null)
                break;
            left = left.next;
        }
        right = left.next;
        left.next = null;
        left = head;
        right = reverse(right);
        merge(left, right);
    }
    public ListNode reverse(ListNode p) {
        ListNode prehead = new ListNode(-1);
        prehead.next = p;
        while(p.next!=null) {
            p = p.next;
        }
        while(prehead.next!=p) {
            ListNode tmp = prehead.next;
            prehead.next = prehead.next.next;
            tmp.next = p.next;
            p.next = tmp;
        }
        return prehead.next;
    }
    public void merge(ListNode left, ListNode right) {
        while(left!=null && right!=null) {
            ListNode tmp = right.next;
            right.next = left.next;
            left.next = right;
            left = left.next.next;
            right = tmp;
        }
    }
}
