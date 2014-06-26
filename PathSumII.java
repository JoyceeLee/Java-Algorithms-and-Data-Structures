/**
* Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
* 
* For example:
* Given the below binary tree and sum = 22,
*                5
*              /  \
*             4    8
*            /    / \
*           11   13  4
*          / \      / \
*         7   2    5   1
* return
* [
*    [5,4,11,2],
*    [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        findPath(ret, cur, root, sum, 0);
        return ret;
    }
    public void findPath(List<List<Integer>> ret, List<Integer> cur, TreeNode root, int sum, int tmp) {
        if(root==null)  return;
        cur.add(root.val);
        tmp += root.val;
        if(root.left==null && root.right==null) {
            if(tmp==sum) {
                ret.add(new List<Integer>(cur));
            }
        }
        findPath(ret, cur, root.left, sum, tmp);
        findPath(ret, cur, root.right, sum, tmp);
        cur.remove(cur.size()-1);
    }
}
