/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]
 */
 
Solution 1. With TreeMap / HashMap 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (root == null) return list;
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        LinkedList<TreeNode> node = new LinkedList<TreeNode>();
        LinkedList<Integer> col = new LinkedList<Integer>();
        node.add(root);
        col.add(0);
        while (!node.isEmpty()) {
            TreeNode tmp = node.poll();
            int cur = col.poll();
            if (!map.containsKey(cur)) {
                map.put(cur, new ArrayList<Integer>());
            }
            map.get(cur).add(tmp.val);
            if (tmp.left != null) {
                node.add(tmp.left);
                col.add(cur-1);
            }
            if (tmp.right != null) {
                node.add(tmp.right);
                col.add(cur+1);
            }
        }
        for (Integer key : map.keySet()) {
            list.add(map.get(key));
        }
        return list;
    }
}

Solution 2. No map need
public class Solution {
    private int min, max;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        
        getRange(root, 0);
        
        for (int i = min; i <= max; i++) {
            list.add(new ArrayList<Integer>());
        }
        LinkedList<TreeNode> node = new LinkedList<>();
        LinkedList<Integer> col = new LinkedList<>();
        node.add(root);
        col.add(-min);
        while (!node.isEmpty()) {
            TreeNode tmp = node.poll();
            int cur = col.poll();
            list.get(cur).add(tmp.val);
            if (tmp.left != null) {
                node.add(tmp.left);
                col.add(cur-1);
            }
            if (tmp.right != null) {
                node.add(tmp.right);
                col.add(cur+1);
            }
        }
        return list;
    }
    
    private void getRange(TreeNode root, int col) {
        if (root == null) return;
        min = Math.min(min, col);
        max = Math.max(max, col);
        getRange(root.left, col-1);
        getRange(root.right, col+1);
    }
}
