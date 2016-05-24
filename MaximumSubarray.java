// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.


public class Solution {
    public int maxSubArray(int[] A) {
      int sum = A[0];
      int max = A[0];
      for(int i=1; i<A.length; i++){
        sum = sum < 0 ? A[i]:(sum+A[i]);
        max = max > sum ? max:sum;
      }
      return max;
    }
}
