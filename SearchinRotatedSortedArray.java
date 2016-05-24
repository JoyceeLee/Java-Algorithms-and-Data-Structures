// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.


public class Solution {
    public int search(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        int ret = find(A, left, right, target);
        return ret;
    }
    public int find(int[] A, int left, int right, int target) {
        int index = -1;
        
        if(left>right) 
            return index;
            
        int mid = (left+right)>>1;
        if(A[mid]==target) 
            return mid;
        
        if(A[right]>A[left]) {
            if(A[mid]>target) {
                return find(A, left, mid-1, target);
            } else {
                return find(A, mid+1, right, target);
            }
        } else {
            index = find(A, left, mid-1, target);
            index = index==-1 ? find(A, mid+1, right, target) : index;
            return index;
        }
    }
}
