/** 
* Given a binary tree, return the preorder traversal of its nodes' values.
* 
* For example:
* Given binary tree {1,#,2,3},
*    1
*     \
*      2
*     /
*    3
* return [1,2,3].
* 
* Note: Recursive solution is trivial, could you do it iteratively?
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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
      ArrayList<Integer> ret = new ArrayList<Integer>();
      if(root==null) return ret;
      Stack<TreeNode> st = new Stack<TreeNode>();
      st.push(root);
      while(!st.isEmpty()) {
        TreeNode tmp = st.pop();
        ret.add(tmp.val);
        if(tmp.right!=null) {
          st.push(tmp.right);
        }
        if(tmp.left!=null) {
          st.push(tmp.left);
        }
      }
      return ret;
    }
}
