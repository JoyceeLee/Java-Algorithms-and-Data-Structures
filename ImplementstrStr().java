// Implement strStr().

// Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.


public class Solution {
    public String strStr(String haystack, String needle) {
        int hslen = haystack.length();
        int needlelen = needle.length();
        if(needlelen==0) return haystack;
        int[] T = new int[needlelen];
        T[0] = -1;
        for(int i=1; i<needlelen; i++) {
            if(T[i-1]>-1 && needle.charAt(i-1)==needle.charAt(T[i-1])) {
                T[i] = T[i-1]+1;
            } else T[i] = 0;
        }
        int i=0;
        int m=0;
        while(m+i<hslen) {
            if(haystack.charAt(m+i)==needle.charAt(i)) {
                i++;
                if(i==needlelen) return haystack.substring(m);
            } else {
                if(T[i]>-1) {
                    m = m+i-T[i];
                    i = T[i];
                } else {
                    m = m+1;
                    i = 0;
                }
            }
        }
        return null;
    }
}
