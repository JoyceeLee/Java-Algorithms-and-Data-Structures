// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.


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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null) return head;
        ListNode preleft = null;
        ListNode leftrun = null;
        ListNode preright = null;
        ListNode rightrun = null;
        while(head!=null) {
            if(head.val<x) {
                if(preleft==null) {
                    preleft = head;
                    leftrun = preleft;
                } else {
                    leftrun.next = head;
                    leftrun = leftrun.next;
                }
            } else {
                if(preright == null) {
                    preright = head;
                    rightleft = preright;
                } else {
                    rightrun.next = head;
                    rightrun = rightrun.next;
                }
            }
            head = head.next;
        }
        if(preright!=null) 
            rightrun.next = null;
        if(preleft==null) {
            return preright;
        } else {
            leftrun.next = preright;
            return preleft;
        }
    }
}
