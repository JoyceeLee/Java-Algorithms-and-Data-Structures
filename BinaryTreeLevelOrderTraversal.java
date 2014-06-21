/**
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
* 
* For example:
* Given binary tree {3,9,20,#,#,15,7},
*     3
*    / \
*   9  20
*     /  \
*    15   7
* return its level order traversal as:
* [
*   [3],
*   [9,20],
*   [15,7]
* ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
          if(root==null) return ret;
          int curNum = 1;
          int nextNum = 0;
          Queue<TreeNode> que = new LinkedList<TreeNode>();
          que.offer(root);
          List<Integer> level = new ArrayList<Integer>();
          while(!que.isEmpty()) {
               TreeNode tmp = que.poll();
               level.add(tmp.val);
               curNum--;
               if(tmp.left!=null) {
                    que.offer(tmp.left);
                    nextNum++;
               }
               if(tmp.right!=null) {
                    que.offer(tmp.right);
                    nextNum++;
               }
               if(curNum==0) {
                    ret.add(new ArrayList<Integer>(level));
                    level.clear();
                    curNum = nextNum;
                    nextNum = 0;
               }
          }
          return ret;
    }
}
