/**
* Given a string s, partition s such that every substring of the partition is a palindrome.
* 
* Return the minimum cuts needed for a palindrome partitioning of s.
* 
* For example, given s = "aab",
* Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
* /


intpublic class Solution {
    public int minCut(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = new int[s.length()+1];
        for(int i=s.length()-1; i>=0; i--) {
            count[i] = Integer.MAX_VALUE;
            for(j=i; j<s.length(); j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count[i] = Math.min(count[j+1]+1, count[i]);
                }
            }
        }
        return count[0]-1;
    }
}
