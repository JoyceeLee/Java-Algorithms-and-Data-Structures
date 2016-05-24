// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode construct(int[] preorder, int pres, int pree, int[] inorder, int ins, int ine) {
        if(pres>pree || ins>ine) return null;
        int rootVal = preorder[pres];
        int idx = ins;
        while(inorder[idx]!=rootVal) {
            idx++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = construct(preorder, pres+1, idx-ins+pres, inorder, ins, idx-1);
        root.right = construct(preorder, idx-ins+pres+1, pree, inorder, idx+1, ine);
        return root;
    }
}
