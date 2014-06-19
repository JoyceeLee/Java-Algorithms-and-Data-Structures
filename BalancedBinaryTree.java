// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
    public boolean isBalanced(TreeNode root) {
      if(root==null) return true;
      return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getDepth(root.left)-getDepth(root.right))<2;
    }
    public getDepth(TreeNode root) {
      if(root==null) return 0;
      return Math.max(getDepth(root.left), getDepth(root.right))+1;
    }
}
