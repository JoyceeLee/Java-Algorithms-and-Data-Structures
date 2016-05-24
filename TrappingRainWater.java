// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


public class Solution {
    public int trap(int[] A) {
        int left = 0;
        int right = A.length-1;
        int i = 1;
        int j = A.length-2;
        int sum = 0;
        while(i<=j) {
            if(A[left]<A[right]) {
                if(A[left]>A[i]) {
                    sum += A[left]-A[i];
                } else {
                    left = i;
                }
                i++;
            } else {
                if(A[right]>A[j]) {
                    sum += A[right]-A[j];
                } else {
                    right = j;
                }
                j--;
            }
        }
        return sum;
    }
}
