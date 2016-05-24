// Sort a linked list using insertion sort.


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
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode run = head;
        while(run!=null && run.next!=null) {
            if(run.val>run.next.val) {
                ListNode pre = prehead;
                while(pre.next.val<run.next.val) {
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                pre.next = run.next;
                run.next = run.next.next;
                pre.next.next = tmp; 
            } else {
                run = run.next;
            }
        }
        return prehead.next;
    }
}
