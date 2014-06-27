// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note: You may assume that duplicates do not exist in the tree.


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = construct(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        return root;
    }
    public TreeNode construct(int[] inorder, int ins, int ine, int[] postorder, int posts, int poste) {
        if(ins>ine || posts>poste) return null;
        int rootVal = postorder[poste];
        int idx = 0;
        while(inorder[idx]!=rootVal) {
            idx++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = construct(inorder, ins, idx-1, postorder, posts, posts+idx-ins-1);
        root.right = construct(inorder, idx+1, ine, postorder, posts+idx-ins, poste-1);
        return root;
    }
}
