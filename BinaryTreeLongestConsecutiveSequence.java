/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,
   1
    \
     3
    / \
   2   4
        \
         5
Longest consecutive sequence path is 3-4-5, so return 3.
   2
    \
     3
    / 
   2    
  / 
 1
Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
*/

// Solution 1. with Global variable
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
    private int longest = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return longest;
    }
    public int helper(TreeNode root) {
        if (root == null) return 0;
        
        int retl = 1, retr = 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if (root.left != null && root.val + 1 == root.left.val) {
            retl += left;
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            retr += right;
        }
        int ret = Math.max(retl, retr);
        longest = Math.max(ret, longest);
        return ret; // return longest path start from root
    }
}

// Solution 2. without Global variable
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
    public int longestConsecutive(TreeNode root) {
        return root == null ? 0 : Math.max(dfs(root.left, 1, root.val), dfs(root.right, 1, root.val));
    }
    
    private int dfs(TreeNode root, int count, int val) {
        if (root == null) return count;
        
        count = (val + 1 == root.val) ? count + 1 : 1; // current consecutive path end in root
        int left = dfs(root.left, count, root.val);
        int right = dfs(root.right, count, root.val);
        return Math.max(count, Math.max(left, right)); // return longest path in the subtree of root(may not include root) OR that contains root
    }
}
