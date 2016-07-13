/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
*/

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

// Solution 1. Morris Traversal
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            if (cur.left != null) {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    str.append(cur.val);
                    str.append(',');
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    str.append("#,");
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                str.append(cur.val);
                str.append(',');
                str.append("#,");
                cur = cur.right;
            }
        }
        str.append("#"); // Don't let ',' be the last character, otherwise, there will be an empty '' be splitted out
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> vals = new LinkedList<String>();
        vals.addAll(Arrays.asList(data.split(",")));
        TreeNode root = buildTree(vals);
        return root;
    }
    
    private TreeNode buildTree(LinkedList<String> vals) {
        if (vals == null || vals.size() == 0) return null;
        
        String val = vals.remove();
        if (val.equals("#")) return null;
        
        TreeNode cur = new TreeNode(Integer.valueOf(val));
        cur.left = buildTree(vals);
        cur.right = buildTree(vals);
        
        return cur;
    }
}

// Solution 2. Recursion
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        buildString(root, str);
        return str.toString();
    }
    
    private void buildString(TreeNode cur, StringBuilder str) {
        if (cur == null) {
            str.append("X,");
        } else {
            str.append(cur.val);
            str.append(',');
            buildString(cur.left, str);
            buildString(cur.right, str);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("X")) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
