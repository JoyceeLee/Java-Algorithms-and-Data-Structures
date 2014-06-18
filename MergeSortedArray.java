// Given two sorted integer arrays A and B, merge B into A as one sorted array.

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
      int i = m-1;
      int j = n-1;
      for(int k=i+j+1; k>-1; k--) {
        if(j<0) return;
        if(i<0) A[k] = B[j--];
        else {
          A[k] = A[i] > B[j] ? A[i--] : B[j--]; // ! ! !
        }
      }
    }
}
