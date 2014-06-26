/**
* Given a binary tree, flatten it to a linked list in-place.
* For example,
* Given
*          1
*         / \
*        2   5
*       / \   \
*      3   4   6
* The flattened tree should look like:
*    1
*     \
*      2
*       \
*        3
*         \
*          4
*           \
*            5
*             \
*              6
* /

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
    public void flatten(TreeNode root) {
        if(root!=null) {
            flat(root);
        }
        return;
    }
    public TreeNode flat(TreeNode root) {
        if(root.left==null && root.right==null) return root;
        if(root.left!=null) {
            TreeNode tmp = flat(root.left);
            tmp.right = root.right;
            root.right = root.left;
            root.left = null;
            if(tmp.right!=null) return flat(tmp.right);
            else return tmp;
        }
        return flat(root.right);
    }
}
