/**
* Binary Tree Level Order Traversal II
* 
* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
* 
* For example:
* Given binary tree {3,9,20,#,#,15,7},
*     3
*    / \
*   9  20
*     /  \
*    15   7
* return its bottom-up level order traversal as:
* [
*   [15,7]
*   [9,20],
*   [3],
* ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      if(root==null) return ret;
      List<Integer> curLevel = new ArrayList<Integer>();
      Queue<TreeNode> que = new LinkedList<TreeNode>();
      que.offer(root);
      int curNum = 1;
      int nextNum = 0;
      while(!que.isEmpty()) {
        TreeNode tmp = que.poll();
        curLevel.add(tmp.val);
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
          ret.add(new ArrayList<Integer>(curLevel));
          curNum = nextNum;
          nextNum = 0;
          curLevel.clear();
        }
      }
      Collections.reverse(ret);
      return ret;
    }
}
