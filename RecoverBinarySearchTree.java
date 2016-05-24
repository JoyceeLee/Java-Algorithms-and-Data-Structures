// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?


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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode last = null;
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first!=null && second!=null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
    public void inorder(TreeNode root) {
        if(root==null) {
            return;
        }
        inorder(root.left);
        if(last!=null) {
            if(last.val>root.val) {
                if(first==null) {
                    first = last;
                }
                second = root;
            }
        }
        last = root;
        inorder(root.right);
    }
}
