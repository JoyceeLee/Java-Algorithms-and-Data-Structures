/**
* Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
* 
* Do not allocate extra space for another array, you must do this in place with constant memory.
* 
* For example,
* Given input array A = [1,1,2],
* 
* Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A==null || A.length==0) return;
        int idx1 = 0;
        int idx2 = 1;
        while(idx2<A.length) {
          if(A[idx1]!=A[idx2] {
            A[++idx1] = A[idx2];
          }
          idx2++;
        }
        return idx1+1;
    }
}
