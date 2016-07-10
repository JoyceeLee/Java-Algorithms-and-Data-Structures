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
 
// Solution 1. Recursion
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

// Solution 2. Morris Traversal
public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode link = null;
        TreeNode n1 = null, n2 = null;
        
        while (cur != null) {
            if (cur.left != null) {
                link = cur.left;
                while (link.right != null && link.right != cur) {
                    link = link.right;
                }
                if (link.right == null) {
                    link.right = cur;
                    cur = cur.left;
                } else {
                    link.right = null;
                    if (pre != null && pre.val >= cur.val) {
                        if (n1 == null) {
                            n1 = pre;
                        }
                        n2 = cur;
                    }
                    pre = cur; // visit
                    cur = cur.right;
                }
            } else {
                if (pre != null && pre.val >= cur.val) {
                    if (n1 == null) {
                        n1 = pre;
                    }
                    n2 = cur;
                }
                pre = cur; // visit
                cur = cur.right;
            }
        }
        
        int swap = n1.val;
        n1.val = n2.val;
        n2.val = swap;
    }
}
