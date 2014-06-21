/**
* Given a binary tree, return the postorder traversal of its nodes' values.
* 
* For example:
* Given binary tree {1,#,2,3},
*    1
*     \
*      2
*     /
*    3
* return [3,2,1].
* 
* Note: Recursive solution is trivial, could you do it iteratively?
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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode pre = null;
        TreeNode cur = root;
        while(!st.isEmpty() || cur!=null) {
            if(cur!=null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                if(cur.right==null || pre = cur.right) {
                    ret.add(cur.val);
                    pre = cur;
                    cur = null;
                } else {
                    st.push(cur);
                    cur = cur.right;
                }
            }
        }
        return ret;
    }
}
