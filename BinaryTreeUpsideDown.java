
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null)  
            return null;  
        TreeNode parent = root, left = root.left, right = root.right;  
        if (left != null) {  
            TreeNode ret = upsideDownBinaryTree(left);  
            left.left = right;
            left.right = parent;
            root.left = null;
            root.right = null;
            return ret;
        }
        return root;
    }
}
