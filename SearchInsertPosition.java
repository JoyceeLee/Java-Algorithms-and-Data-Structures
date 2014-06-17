/**
* Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
* 
* You may assume no duplicates in the array.
* 
* Here are few examples.
* [1,3,5,6], 5 → 2
* [1,3,5,6], 2 → 1
* [1,3,5,6], 7 → 4
* [1,3,5,6], 0 → 0
*/

// Solution <1>

public class Solution {
    public int searchInsert(int[] A, int target) {
      int idx = 0;
      while(idx<A.length && A[idx]<target) {
          idx++;
      }
      return idx;
    }
}

// Solution <2>

public class Solution {
    public int searchInsert(int[] A, int target) {
         if (A.length == 0 || target<A[0]) return 0;
         else if(target>A[A.length-1]) return A.length;
         else return search(0, A.length-1, A, target);
    }
    public int search(int left, int right, int[] A, int target) {
         int mid = (left+right)>>1;
         if(A[mid]==target) return mid; // check left first if (r-l==1)
         if((right-left)==1)     return right;
         if(A[mid]<target) return search(mid, right, A, target);
         return search(left, mid, A, target);
    }
}
