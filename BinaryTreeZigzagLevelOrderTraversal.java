/**
* Given a binary tree, return the zigzag level order traversal of its nodes' values. 
* (ie, from left to right, then right to left for the next level and alternate between).
* 
* For example:
* Given binary tree {3,9,20,#,#,15,7},
*     3
*    / \
*   9  20
*     /  \
*    15   7
* return its zigzag level order traversal as:
* [
*   [3],
*   [20,9],
*   [15,7]
* ]


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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
            if(root==null) return ret;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        boolean left=true;
       
        que.add(root);
        int cur = 1;
        int nex = 0;
        while(!que.isEmpty()) {
            TreeNode p = que.remove();
            tmp.add(p.val);
            cur--;
            if(p.left!=null) {
                que.add(p.left);
                nex++;
            }
            if(p.right!=null) {
                que.add(p.right);
                nex++;
            }
            if(cur==0) {
               if(!left) {
                   Collections.reverse(tmp);
               }
               left ^= true;
               ret.add(tmp);
               tmp = new ArrayList<Integer>();
               cur = nex;
               nex=0;
            }
        }
        return ret;
    }
}
