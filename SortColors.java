// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.


public class Solution {
    public void sortColors(int[] A) {
        int i = 0;
        int j = A.length-1;
        int k = j;
        while (i<=j) {
            if(A[i]==2) {
                int tmp = A[k];
                A[k] = A[i];
                A[i] = tmp;
                k--;
                if(k<j) j=k;
            } else if(A[i]==1) {
                int tmp = A[j];
                A[j] = A[i];
                A[i] = tmp;
                j--;
            }
            else i++;
        }
    }
}
