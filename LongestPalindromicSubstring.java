/**
* Given a string S, find the longest palindromic substring in S. 
* You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/


public class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0) 
            return s;
        int len = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        boolean[][] palind = new boolean[len][len];
        for(int i=len-1; i>=0; i--) {
            for(int j=i; j<len; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || palind[i+1][j-1])) {
                    palind[i][j] = true;
                    if(j-i+1>max) {
                        max = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
