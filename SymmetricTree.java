/**
* Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
* 
* For example, this binary tree is symmetric:
* 
*     1
*    / \
*   2   2
*  / \ / \
* 3  4 4  3
* But the following is not :
*     1
*    / \
*   2   2
*    \   \
*    3    3
* Note :
* Bonus points if you could solve it both recursively and iteratively.
*/

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
    public boolean isSymmetric (TreeNode root) {
      if(root==null) return true;
      return Sym(root.left, root.right);
    }
    public boolean Sym(TreeNode left, TreeNode right) {
      if(left==null || right==null)
        return left==null && right==null;
      return Sym(left.left, right.right) && Sym(left.right, right.left);
    }
 }
 
 
 public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null || root.right==null)
            return root.left==null && root.right==null;
        Queue<TreeNode> st = new LinkedList<TreeNode>();
        st.offer(root.left);
        st.offer(root.right);
        while(!st.isEmpty()) {
            TreeNode t1 = st.poll();
            TreeNode t2 = st.poll();
            if(t1.val!=t2.val) return false;


            if(t1.left!=null && t2.right!=null) {
                st.offer(t1.left);
                st.offer(t2.right);
            } else {
                if(!(t1.left==null && t2.right==null))
                    return false;
            }
            if(t1.right!=null && t2.left!=null) {
                st.offer(t1.right);
                st.offer(t2.left);
            } else {
                if(!(t1.right==null && t2.left==null))
                    return false;
            }
        }
        return true;
    }
}
