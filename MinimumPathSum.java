// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.


public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathSum = new int[m][n];
        pathSum[0][0] = grid[0][0];
        for(int i=1; i<n; i++) {
            pathSum[0][i] = pathSum[0][i-1] + grid[0][i];
        }
        for(int i=1; i<m; i++) {
            pathSum[i][0] = pathSum[i-1][0] + grid[i][0];
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                pathSum[i][j] = Math.min(pathSum[i-1][j], pathSum[i][j-1])+grid[i][j];
            }
        }
        return pathSum[m-1][n-1];
    }
}
