// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//   1         3      3      2      1
//    \       /      /      / \      \
//     3     2       1     1   3      2
//    /     /        \                 \
//   2     1          2                 3


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return construct(1, n);
    }
    public ArrayList<TreeNode> construct(int start, int end) {
        ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        if(start>end) ret.add(null);
        for(int i=start; i<=end; i++) {
            ArrayList<TreeNode> leftTrees = construct(start, i-1);
            ArrayList<TreeNode> rightTrees = construct(i+1, end);
            for(TreeNode leftNode : leftTrees)
                for(TreeNode rightNode : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ret.add(root);
                }
        }
        return ret;
    }
}
