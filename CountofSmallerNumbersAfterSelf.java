/*
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example:
 * Given nums = [5, 2, 6, 1]
 *
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 */
 
 // Solution 1. Binary Search Tree
 public class Solution {
    class Node {
        int count; // number of values <= this.val
        int val;
        int dup; // duplication of same value
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) return list;
            
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            min = min < nums[i] ? min : nums[i];
            max = max > nums[i] ? max : nums[i];
        }
        int mid = (max - min) / 2;
        Node root = new Node(mid);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            insert(root, list, nums[i], 0);
        }
        return list;
    }
    
    public Node insert(Node root, LinkedList<Integer> list, int val, int sum) {
        if (root == null) {
            list.addFirst(sum);
            Node cur = new Node(val);
            cur.dup = 1;
            cur.count = 1;
            return cur;
        }
        
        if (val < root.val) {
            root.left = insert(root.left, list, val, sum);
            root.count += 1;
        } else if (val == root.val) {
            sum += root.count - root.dup;
            list.addFirst(sum);
            root.dup += 1;
            root.count += 1;
        } else {
            sum += root.count;
            root.right = insert(root.right, list, val, sum);
        }
        
        return root;
    }
}

// Solution 2. Binary Indexed Tree
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) return list;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min < i ? min : i;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1; // BITree index start from 1
            max = max > nums2[i] ? max : nums2[i];
        }
        
        int[] BITree = new int[max + 1];
        for (int i = nums2.length - 1; i >= 0; i--) {
            list.addFirst(getSum(nums2[i] - 1, BITree)); // less than, not include equals to
            updateBIT(nums2[i], BITree);
        }
        return list;
    }
    
    private int getSum(int i, int[] bitree) {
        int sum = 0;
        while (i > 0) {
            sum += bitree[i];
            i -= i & (-i);
        }
        return sum;
    }
    
    private void updateBIT(int i, int[] bitree) {
        while (i < bitree.length) {
            bitree[i] += 1;
            i += i & (-i);
        }
    }
}
