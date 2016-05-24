/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

// Soution 1. DFS - Time O(mn), Space O(mn)
// use Pathlen[][] to record longest path for each {i,j}
public class Solution {
    public static final int[] shift = {-1, 0, 1, 0, -1};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] pathlen = new int[m][n];
        int max = 0;
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, pathlen);
                max = max > len ? max : len;
            }
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] pathlen) {
        if (pathlen[i][j] != 0) return pathlen[i][j];
        
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int r = i + shift[k];
            int c = j + shift[k + 1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[i][j])
                max = Math.max(max, 1 + dfs(matrix, r, c, pathlen));
        }
        pathlen[i][j] = max;
        return max;
    }
}

// Solution 2. Topological Sort - Time O(mn), Space O(mn)
public class Solution {
    public static final int[] shift = {-1, 0, 1, 0, -1};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
            
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<Integer> quer = new LinkedList<Integer>();
        Queue<Integer> quec = new LinkedList<Integer>();
        int[] indegree = new int[m * n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                for (int k = 0; k < 4; k++) {
                    int r = i + shift[k];
                    int c = j + shift[k + 1];
                    if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] < matrix[i][j]) {
                        indegree[i * n + j] += 1;
                    }
                }
                if (indegree[i * n + j] == 0) {
                    quer.offer(i);
                    quec.offer(j);
                }
            }
        }
        
        int len = 0;
        while (!quer.isEmpty()) {
            int size = quer.size();
            while (size > 0) {
                int i = quer.poll();
                int j = quec.poll();
                for (int k = 0; k < 4; k++) {
                    int r = i + shift[k];
                    int c = j + shift[k + 1];
                    if (r >= 0 && r < m && c >= 0 && c < n && matrix[i][j] < matrix[r][c]) {
                        indegree[r * n + c] -= 1;
                        if (indegree[r * n + c] == 0) {
                            quer.offer(r);
                            quec.offer(c);
                        }
                    }
                }
                size--;
            }
            len++;
        }
        return len;
    }
}
