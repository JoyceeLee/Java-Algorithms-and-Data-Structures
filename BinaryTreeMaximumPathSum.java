/*
* Given a binary tree, find the maximum path sum.
* 
* The path may start and end at any node in the tree.
* 
* For example:
* Given the below binary tree,
*        1
*       / \
*      2   3
* Return 6.


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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxSum(root);
        return maxSum;
    }
    public int getMaxSum(TreeNode root) {
        if(root==null) return 0;
        int leftsum = getMaxSum(root.left);
        int rightsum = getMaxSum(root.right);
        int sum = root.val;
        if(leftsum>0) { sum += leftsum; }
        if(rightsum>0) { sum += rightsum; }
        maxSum = maxSum > sum ? maxSum : sum;
        int ret = Math.max(leftsum, rightsum) > 0 ? Math.max(leftsum, rightsum)+root.val : root.val;
        return ret;
    }
}
