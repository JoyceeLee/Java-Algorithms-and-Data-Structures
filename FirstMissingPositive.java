/**
* Given an unsorted integer array, find the first missing positive integer.
* 
* For example,
* Given [1,2,0] return 3,
* and [3,4,-1,1] return 2.
* 
* Your algorithm should run in O(n) time and uses constant space.
* /


public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A==null || A.length==0)
            return 1;
        int len = A.length;
        for(int i=0; i<len; ) {
            if(A[i]>0 && A[i]<len && A[i]!=i && A[A[i]]!=A[i]) {
                int tmp = A[i];
                A[i] = A[A[i]];
                A[A[i]] = A[i];
            } else // until find i in A or i is not in A
                i++;
        }
        for(int i=0; i<len; i++) {
            if(A[i]!=i)
                return i;
        }
        return A[0]==len ? len+1 : len;
    }
}
