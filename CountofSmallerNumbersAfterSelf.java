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

// Solution 2. Divide and Conquer - Merge Sort
public class Solution {
    class Pair {
        int idx;
        int val;
        public Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
        
    }
    public List<Integer> countSmaller(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return list;
        
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++)
            pairs[i] = new Pair(i, nums[i]);
        Integer[] smaller = new Integer[nums.length]; // before fill, smaller[i] is empty
        Arrays.fill(smaller, 0);
        countWhileMergeSort(pairs, smaller, 0, pairs.length);
        
        list.addAll(Arrays.asList(smaller));
        return list;
    }
    
    private void countWhileMergeSort(Pair[] pairs, Integer[] smaller, int start, int end) {
        if (start + 1 >= end) return;
        int mid = (end - start) / 2 + start;
        countWhileMergeSort(pairs, smaller, start, mid);
        countWhileMergeSort(pairs, smaller, mid, end);
        
        Pair[] tmp = new Pair[end - start];
        int id = 0;
        int i = start, j = mid;
        int count = 0;
        for (; i < mid; i++) {
            while (j < end && pairs[i].val > pairs[j].val) {
                count++;
                tmp[id++] = pairs[j++];
            }
            smaller[pairs[i].idx] += count;
            tmp[id++] = pairs[i];
        }
        System.arraycopy(tmp, 0, pairs, start, id);
    }
}

// Solution 3. Binary Indexed Tree
// In the case of [2147483647,-2147483648,-1,0], there will be error: java.lang.ArrayIndexOutOfBoundsException: -2147483647
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
