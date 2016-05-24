/**
* Given a list, rotate the list to the right by k places, where k is non-negative.
*
* For example:
* Given 1->2->3->4->5->NULL and k = 2,
* return 4->5->1->2->3->NULL.
* /


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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null) return head;
        ListNode run = head;
        int len = 1;
        while(run.next!=null) {
            run = run.next;
            len++;
        }
        run.next = head;
        int step = len - n % len;
        while(step>0) {
            step--;
            run = run.next;
        }
        head = run.next;
        run.next=null;
        return head;
    }
}
