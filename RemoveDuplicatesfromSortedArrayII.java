// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array A = [1,1,1,2,2,3],

// Your function should return length = 5, and A is now [1,1,2,2,3].


public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length<=1)
          return A.length;
        int idx = 0;
        int cur = 0;
        int pre = 0;
        while(pre<A.length) {
            cur = pre;
            while(pre<A.length && A[idx]==A[pre]) {
                pre++;
            }
            if(pre-cur==1) {
                idx++;
            } else {
                A[idx+1] = A[idx];
                idx += 2;
            }
            if(pre<A.length) {
                A[idx] = A[pre];
            }
        }
        return idx;
    }
}
