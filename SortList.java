/**
* Sort a linked list in O(n log n) time using constant space complexity.
*
* 1. Break list in the middle to two lists (use fast & slow pointers)
* 2. Merge two list back together
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode left = head;
        ListNode right = head;
        while(right.next!=null) {
            right = right.next.next;
            if(right==null) break;
            left = left.next;
        }
        right = left.next;
        left.next = null;
        left = sortList(head);
        right = sortList(right);
        return merge(left, right);
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode prehead = new ListNode(-1);
        ListNode run = prehead;
        while(left!=null && right!=null) {
            if(left.val<=right.val) {
                run.next = left;
                left = left.next;
            } else {
                run.next = right;
                right = right.next;
            }
            run = run.next;
        }
        if(left!=null) {
            run.next = left;
        } else {
            run.next=right;
        }
        return prehead.next;
    }
}

/**
* Time Complexity : O(n log n)
* Space Complexity : O(log n)
*/ 
