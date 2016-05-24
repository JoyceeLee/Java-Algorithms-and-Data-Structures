// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
Solution 1 Recursion
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper (root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, int min, int max) {
        if (root==null) return true;
        if (root.val<min) return false;
        if (root.val>max) return false;
        if (root.val==Integer.MIN_VALUE) {
            return root.left==null && helper(root.right, root.val+1, max);
        }
        if (root.val==Integer.MAX_VALUE) {
            return helper(root.left, min, root.val-1) && root.right==null;
        }
        return helper(root.left, min, root.val-1) && helper(root.right, root.val+1, max);
    }
}

Solution 2.1 inOrderTraversal
public class Solution {
    public boolean isValidBST(TreeNode root) {
        int val = Integer.MIN_VALUE;
        boolean first = true;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (cur!=null || !stack.isEmpty()) {
            if (cur!=null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (val>=cur.val) {
                    if (val==Integer.MIN_VALUE && first) {
                        first = false;
                    } else {
                        return false;
                    }
                }
                val = cur.val;
                cur = cur.right;
            }
        }
        return true;
    }
}

Solution 2.2 inOrderTraversal without Stack
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        int min = Integer.MIN_VALUE;
        while (cur != null) {
            pre = cur.left;
            if (pre == null) {
                if (cur.val < min) {
                    return false;
                }
                if (cur.val == Integer.MAX_VALUE) {
                    return cur.right == null;
                }
                min = cur.val + 1;
                cur = cur.right;
            } else {
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    if (cur.val < min) {
                        return false;
                    }
                    if (cur.val == Integer.MAX_VALUE) {
                        return cur.right == null;
                    }
                    min = cur.val + 1;
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return true;
    }
}

Wrong Solution
1. Recursion，是 [min,max] 而不是 (min,max), (min,max], [min,max)
2. root.val 不能 -1 或者 +1 的情况
   return helper(root.left, min, root.val-1) && helper(root.right, root.val+1, max); 
