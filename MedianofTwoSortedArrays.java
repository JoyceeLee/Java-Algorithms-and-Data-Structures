/**
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */

// 06/26/2016 
// K is the total number of elements before and include the "median"
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (((m + n) & 1) == 1) return (double)(findKth(nums1, 0, m-1, nums2, 0, n-1, (m + n) / 2 + 1));
        int low = findKth(nums1, 0, m-1, nums2, 0, n-1, (m + n) / 2 + 1);
        int high = findKth(nums1, 0, m-1, nums2, 0, n-1, (m + n) / 2);
        return (double) (high + low) * 0.5;
    }
    
    private int findKth(int[] nums1, int s1, int t1, int[] nums2, int s2, int t2, int k) {
        int len1 = t1 - s1 + 1;
        int len2 = t2 - s2 + 1;
        if (len1 == 0) return nums2[s2 + k - 1];
        if (len2 == 0) return nums1[s1 + k - 1];
        if (k == 1) return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];
        
        int idx1 = len1 * k / (len1 + len2);
        idx1 = (idx1 == 0) ? 1 : idx1; // in case idx1 == 0
        int idx2 = k - idx1;
        idx1 = s1 + idx1 - 1;
        idx2 = s2 + idx2 - 1;
        
        if (nums1[idx1] > nums2[idx2]) {
            k -= idx2 - s2 + 1;
            return findKth(nums1, s1, idx1, nums2, idx2 + 1, t2, k);
        } else if (nums1[idx1] < nums2[idx2]) {
            k -= idx1 - s1 + 1;
            return findKth(nums1, idx1 + 1, t1, nums2, s2, idx2, k);
        } else return nums1[idx1];
    }
}

// First time
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
