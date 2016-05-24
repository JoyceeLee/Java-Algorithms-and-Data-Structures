/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */


/**
 *  DP
 * Time Complexity : O(m*n)
 * Space Complexity : O(min(m, n))
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        
        if(s1.length()<s2.length()) {
            String swap = s2;
            s2 = s1;
            s1 = swap;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[] res = new boolean[n+1];
        
        res[0] = true; 
        for(int j=0;j<n; j++) {  
            res[j+1] = res[j] && s2.charAt(j)==s3.charAt(j);  
        }
        for(int i=0; i<m; i++) {
            res[0] = res[0] && s1.charAt(i)==s3.charAt(i);
            for(int j=0; j<n; j++) {
                res[j+1] = (s1.charAt(i) == s3.charAt(i+j+1) && res[j+1]) || (s2.charAt(j) == s3.charAt(i+j+1) && res[j]);
            }
        }
        return res[n];
    }
}
