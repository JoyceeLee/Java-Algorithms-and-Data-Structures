/*
Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2.
*/

// Solution 0. O(n^2)

// Solution 1. Divide and Conquer -- Merge Sort O(n log n)
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1]; // use long in case out of range
        for (int i = 0; i < n; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        int count = countWhileMerge(sums, 0, n + 1, lower, upper);
        return count;
    }
    
    // [start, end), where start is included well end is excluded
    private int countWhileMerge(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) return 0;
        
        int mid = (end - start) / 2 + start;
        int count = countWhileMerge(sums, start, mid, lower, upper) 
                    + countWhileMerge(sums, mid, end, lower, upper);
        int p = mid, q = mid, t = mid;
        long[] tmp = new long[end - start];
        for (int i = start, j = 0; i < mid; i++) {
            // the sum in back part always has more value than the front part.
            // front part and back part are sorted seperately
            while(p < end && sums[p] < sums[i] + lower) p++;
            while(q < end && sums[q] <= sums[i] + upper) q++;
            while(t < end && sums[t] < sums[i]) tmp[j++] = sums[t++];
            tmp[j++] = sums[i];
            count += q - p;
        }
        System.arraycopy(tmp, 0, sums, start, t - start);
        return count;
    }
}

// Solution 2. Segment Tree
