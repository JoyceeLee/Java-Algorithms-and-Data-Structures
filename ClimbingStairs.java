// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


public class Solution {
    public int climbStairs(int n) {
      if(n<=1) return 1;
      //  else return climbStairs(n-1)+climbStairs(n-2);// time limit error
      int[] A = new int[n+1];
      A[0] = 1;
      A[1] = 1;
      for(int i=2; i<n+1; i++) {
        A[i] = A[i-1]+A[i-2];
      }
      return A[n];
    }
}
