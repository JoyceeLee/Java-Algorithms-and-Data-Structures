/**
* Given a sorted array of integers, find the starting and ending position of a given target value.
* 
* Your algorithm's runtime complexity must be in the order of O(log n).
* 
* If the target is not found in the array, return [-1, -1].
* 
* For example,
* Given [5, 7, 7, 8, 8, 10] and target value 8,
* return [3, 4].
* /


public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] ret = {-1, -1};
        if(A==null || A.length==0)
            return ret;
        double bottom = target-0.5;
        double top = target+0.5;
        int low = binarySearch(A, bottom);
        if(low>=A.length || A[low]!=target) {
            return ret;
        }
        int high = binarySearch(A, top)-1;
        ret[0] = low;
        ret[1] = high;
        return ret;
    }
    public int binarySearch(int[] A, double g) {
        int s = 0;
        int t = A.length-1;
        while(s<=t) {
            int m = (s+t)/2;
            if(A[m]==g) { // can never be true !!!
                return m;
            } else if(A[m]>g) {
                t = m-1;
            } else {
                s = m+1;
            }
        }
        return s; // that is return the int bigger than g ? 
    }
}
