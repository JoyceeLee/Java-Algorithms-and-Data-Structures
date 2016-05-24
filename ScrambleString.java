/**
* Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
* 
* Below is one possible representation of s1 = "great":
* 
*     great
*    /    \
*   gr    eat
*  / \    /  \
* g   r  e   at
*            / \
*           a   t
* To scramble the string, we may choose any non-leaf node and swap its two children.
* 
* For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
* 
*     rgeat
*    /    \
*   rg    eat
*  / \    /  \
* r   g  e   at
*            / \
*           a   t
* We say that "rgeat" is a scrambled string of "great".
* 
* Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
* 
*     rgtae
*    /    \
*   rg    tae
*  / \    /  \
* r   g  ta  e
*        / \
*       t   a
* We say that "rgtae" is a scrambled string of "great".
* 
* Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
* /


public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length) return false;
        int len = s1.length();
        if(len==0) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        boolean[][][] dp = new boolean[len][len][len];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(c1[i]==c2[j]) dp[0][i][j] = true;
            }
        }
        for(int k=2; k<=len; k++) {
            for(int i=len-k; i>=0; i--) {
                for(int j=len-k; j>=0; j--) {
                    for(int m=1; m<k; m++) {
                        if( (dp[m-1][i][j] && dp[k-m-1][i+m][j+m]) ||
                            (dp[m-1][i][j+k-m] && dp[k-m-1][i+m][j]) )
                            dp[k-1][i][j] = true;
                    }
                }
            }
        }
        return dp[len-1][0][0];
    }
}
