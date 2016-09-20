/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
 * as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
 * since a node can be a descendant of itself according to the LCA definition.
 */

// Solution 1. Post-order traversal
/* 
 * 1. When first node is found, all its children have been visited
 * 2. First's parent will be in the stack
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode lcp = null;
        TreeNode cur = root;
        TreeNode pre = null;
        int count = 0;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.right == null || cur.right == pre) {
                    if (cur == p || cur == q) {
                        count++;
                        if (count == 1) lcp = stack.peek(); 
                        if (count == 2) return lcp;
                    }
                    if (cur == lcp) lcp = stack.peek();
                    pre = cur;
                    cur = null;
                } else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return lcp;
    }
}

// Solution 2. Recursion
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if ((left == p && right == q) || (left == q && right == p))  return root;
        if (left == p || left == q) return left;
        if (right == p || right == q) return right;
        if (left != null && right == null) return left;
        if (left == null && right != null) return right;
        return null;
    }
}
