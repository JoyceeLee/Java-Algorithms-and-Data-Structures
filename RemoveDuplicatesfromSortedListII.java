// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

// For example,
// Given 1->2->3->3->4->4->5, return 1->2->5.
// Given 1->1->1->2->3, return 2->3.


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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode ret = null;
        ListNode link = null;
        ListNode cur = head;
        ListNode run = head.next;
        int count = 1;
        while(run!=null) {
            if(cur!=run) {
                if(count==1) {
                    if(ret==null) {
                        ret = cur;
                        link = ret;
                    } else {
                        link.next = cur;
                        link = link.next;
                    }
                }
                cur = run;
                count = 1;
            } else {
                count ++;
            }
            run = run.next;
        }
        if(count==1) {
            if(ret==null) {
                ret = cur;
                link = ret;
            } else {
                link.next = cur;
                link = link.next;
            } 
        }
        if(link!=null) link.next = null;
        return ret;
    }
}
