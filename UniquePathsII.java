/**
* Follow up for "Unique Paths":
* 
* Now consider if some obstacles are added to the grids. How many unique paths would there be?
* 
* An obstacle and empty space is marked as 1 and 0 respectively in the grid.
* 
* For example, There is one obstacle in the middle of a 3x3 grid as illustrated below.
* 
* [
*   [0,0,0],
*   [0,1,0],
*   [0,0,0]
* ]
* The total number of unique paths is 2.
* 
* Note: m and n will be at most 100.
* /


public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        int i=0;
        while(i<m && obstacleGrid[i][0]!=1) {
            paths[i++][0] = 1; 
        }
        i = 0;
        while(i<n && obstacleGrid[0][i]!=1) {
            paths[0][i++] = 1;
        }
        for(int r=1; r<m; r++)
            for(int c=1; c<n; c++) {
                paths[r][c] = obstacleGrid[r][c]==0 ? 0 : paths[r-1][c]+paths[r][c-1];
            }
        return paths[m-1][n-1];
    }
}
