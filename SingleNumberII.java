// Given an array of integers, every element appears three times except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


public class Solution {
    public int singleNumber(int[] A) {
      int once = 0;
      int twice = 0;
      int xthree = 0;
      for(int i=0; i<A.length; i++) {
        int val = A[i];
        twice |= once & val;
        once ^= val;
        xthree = ~(once & twice);
        once &= xthree;
        twice &= xthree;
      }
      return (once | twice);
    }
}
