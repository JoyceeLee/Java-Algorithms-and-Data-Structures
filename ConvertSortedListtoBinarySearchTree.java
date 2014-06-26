// Given a single linked list where elements are sorted in ascending order, convert it to a height balanced BST.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = buildTree(head, null);
        return root;
    }
    public TreeNode buildTree(ListNode head, ListNode end) {
        if(head==end) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=end && fast.next!=end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildTree(head, slow);
        root.right = buildTree(slow.next, end);
        return root;
    }
}
