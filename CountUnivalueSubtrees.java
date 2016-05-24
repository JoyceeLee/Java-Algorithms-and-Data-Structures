/**
 * Given a binary tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * For example:
 * Given binary tree,
 *            5
 *           / \
 *          1   5
 *         / \   \
 *        5   5   5
 * return 4.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int cnt = 0;
    public int countUnivalSubtrees(TreeNode root) {
        helper(root);
        return cnt;
    }
    private boolean helper(TreeNode root) {
        if (root == null) 
            return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if (root.left == null && root.right == null) {
                cnt++;
                return true;
            } else if (root.left == null) {
                if (root.val == root.right.val) {
                    cnt++;
                    return true;
                }
            } else if (root.right == null) {
                if (root.val == root.left.val) {
                    cnt++;
                    return true;
                }
            } else {
                if (root.val == root.left.val && root.val == root.right.val) {
                    cnt++;
                    return true;
                }
            }
        }
        return false;
    }
}
