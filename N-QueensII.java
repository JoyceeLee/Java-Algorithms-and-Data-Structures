// Follow up for N-Queens problem.

// Now, instead outputting board configurations, return the total number of distinct solutions.


public class Solution {
    public int totalNQueens(int n) {
        int[] rows = new int[n];
        return dfs(rows, 0, n);
    }
    public int dfs(int[] rows, int row, int n) {
        if(row==n) return 1;
        int total = 0;
        for(int i=0; i<n; i++) {
            rows[row] = i;
            if(isValid(rows, row)) {
                total += dfs(rows, row+1, n);
            }
        }
        return total;
    }
    public boolean isValid(int[] rows, int row) {
        for(int i=0; i<row; i++) {
            if(rows[i]==rows[row] || Math.abs(i-row)==Math.abs(rows[i]-rows[row]))
                return false;
        }
        return true;
    }
}
