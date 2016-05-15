/*
* Sum of given range
* We have an array arr[0 . . . n-1]. We should be able to
* 1. Find the sum of elements from index l to r where 0 <= l <= r <= n-1 
* 2. Change value of a specified element of the array arr[i] = x where 0 <= i <= n-1.
* 
* To do both operations in O(Logn) time.
*/

/*
 * O(log n) to
 *  - Find the sum from array[l] to array[r]
 *  - Change value of array[i] to x
 */
 
public class SegmentTree {
    private int[] array = null;
    STNode root;
    
    class STNode {
        int start, end;
        int sum;
        STNode left, right;
        public STNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public SegmentTree(int[] arr) {
        array = arr;
        int start = 0, end = array.length-1;
        root = construct(array, start, end);
    }
    public STNode construct(int[] arr, int start, int end) {
        if (start > end) return null;
        STNode node = new STNode(start, end);
        if (start == end) {
            node.sum = arr[start];
            return node;
        }
        int mid = (end - start) / 2 + start;
        node.left = construct(arr, start, mid);
        node.right = construct(arr, mid+1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }
    
    public int getSum(STNode cur, int left, int right) {
        if (cur == null) return 0;
        if (left <= cur.start && right >= cur.end) {
            return cur.sum;
        }
        if (left > cur.end || right < cur.start)
            return 0;
        int mid = (cur.end - cur.start) / 2 + cur.start;
        if (left  <= mid && mid < right)
            return getSum(cur.left, left, mid) + getSum(cur.right, mid+1, right);
        else if (left > mid) return getSum(cur.right, left, right);
        else if (right <= mid) return getSum(cur.left, left, right);
        return 0;
    }
    
    public int updateVal(STNode cur, int newVal, int idx) {
        if (cur.start == idx && cur.end == idx) {
            int ret =  cur.sum - newVal;
            cur.sum = newVal;
            return ret;
        }
        int mid = (cur.end - cur.start) / 2 + cur.start, diff = 0;
        if (idx <= mid) {
            diff = updateVal(cur.left, newVal, idx);
        } else {
            diff = updateVal(cur.right, newVal, idx);
        }
        cur.sum -= diff;
        return diff;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);
        st.getSum(st.root, 0, 4);
        st.updateVal(st.root, 8, 1);
        System.out.println(st.root.sum);
    }
}

/*
 * Other Usage of Segmengt Tree
 * Range Minimum/Maximum Query
 */
