/**
* Given an array of non-negative integers, you are initially positioned at the first index of the array.
* 
* Each element in the array represents your maximum jump length at that position.
* 
* Determine if you are able to reach the last index.
* 
* For example:
* A = [2,3,1,1,4], return true.
* 
* A = [3,2,1,0,4], return false.
* /


public class Solution {
    public boolean canJump(int[] A) {
        if(A==null || A.length==0)
            return false;
        if(A.length==1)
            return true;
        int acc[] = new int[A.length];
        acc[0] = A[0];
        for(int i=1; i<A.length; i++) {
            if(i<=acc[i-1]) {
                acc[i] = Math.max(acc[i-1], A[i]+i);
                if(acc[i]>=A.length-1)
                    retur true;
            } else {
                return false;
            }
        }
        // no useful clause;
        return true;
    }
}
