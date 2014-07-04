/**
* Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
* (each operation is counted as 1 step.)
* 
* You have the following 3 operations permitted on a word:
* 
* a) Insert a character
* b) Delete a character
* c) Replace a character
* /


public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] step = new int[m+1][n+1];
        int k=0;
        while(k<=m || k<=n) {
            if(k<=m) {
                step[k][0] = k;
            }
            if(k<=n) {
                step[0][k] = k;
            }
            k++;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)) {
                    step[i][j] = step[i-1][j-1];
                } else {
                    step[i][j] = Math.min(step[i-1][j-1]+1, Math.min(step[i-1][j]+1, step[i][j-1]+1));
                }
            }
        }
        return step[m][n];
    }
}
