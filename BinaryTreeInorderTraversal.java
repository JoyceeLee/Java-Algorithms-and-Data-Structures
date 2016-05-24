/**
* Given a binary tree, return the inorder traversal of its nodes' values.
* 
* For example:
* Given binary tree {1,#,2,3},
*    1
*     \
*      2
*     /
*    3
* return [1,3,2].
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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
      ArrayList<Integer> ret = new ArrayList<Integer>();
      Stack<TreeNode> st = new Stack<TreeNode>();
      TreeNode p = root;
      while(!st.isEmpty() || p!=null) {
        if(p!=null) {
          st.push(p);
          p = p.left;
        } else {
          p = st.pop();
          ret.add(p.val);
          p = p.right;
        }
      }
      return ret;
    }
}
