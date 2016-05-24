/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */


public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        k = (m+n)/2;
        if((m+n)%2!=0) {
            return (double) findKth(A, B, k, 0, m-1, 0, n-1);
        } else return (findKth(A, B, k, 0, m-1, 0, n-1)+
                       findKth(A, B, k-1, 0, m-1, 0, n-1)) * 0.5;
    }
    public int findKth(int[] A, int[] B, int k, int astart, int aend, int bstart, int bend) {
        if(astart>aend) {
            return B[bstart+k];
        }
        if(bstart>bend) {
            return A[astart+k];
        }
        if(k==0) {
            return A[astart]<=B[bstart] ? A[astart] : B[bstart];
        }
        
        int aLen = aend-astart+1;
        int bLen = bend-bstart+1;
        int aMid = aLen*k/(aLen+bLen);
        int bMid = k-aMid-1;
        aMid = aMid + astart;
        bMid = bMid + bstart;
        if(A[aMid]>B[bMid]) {
            k = k-(bMid-bstart+1);
            aend = aMid;
            bstart = bMid+1;
        } else { // include when A[aMid]==B[bMid]
            k = k-(aMid-astart+1);
            bend = bMid;
            astart = aMid+1;
        }
        return findKth(A, B, k, astart, aend, bstart, bend);
    }
}
