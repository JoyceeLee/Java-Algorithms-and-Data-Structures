/**
* Reverse a linked list from position m to n. Do it in-place and in one-pass.
* 
* For example:
* Given 1->2->3->4->5->NULL, m = 2 and n = 4,
* 
* return 1->4->3->2->5->NULL.
* 
* Note:
* Given m, n satisfy the following condition:
* 1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode last = pre;
        int i=0;
        while(i<n) {
            if(i<m-1) {
                pre = pre.next;
            }
            last = last.next;
            i++;
        }
        while(pre.next!=last) {
            ListNode tmp = pre.next;
            pre.next = pre.next.next;
            tmp.next = last.next;
            Last.next = tmp;
        }
        if(m==1) return pre.next;
        return head;
    }
}
