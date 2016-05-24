// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
      return constructTree(num, 0, num.length-1);
    }
    public TreeNode constructTree(int[] num, int start, int end) {
      if(start>end) return null;
      int mid = (start+end)>>1;
      TreeNode root = new TreeNode(num[mid]);
      root.left = constructTree(num, start, mid-1);
      root.right = constructTree(num, mid+1, end);
      return root;
    }
}
