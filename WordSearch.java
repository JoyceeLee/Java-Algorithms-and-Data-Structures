/**
* Given a 2D board and a word, find if the word exists in the grid.
* 
* The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
* 
* For example,
* Given board =
* 
* [
*   ["ABCE"],
*   ["SFCS"],
*   ["ADEE"]
* ]
* word = "ABCCED", -> returns true,
* word = "SEE", -> returns true,
* word = "ABCB", -> returns false.
*/


// Solution 1> brute force : recursion
// DFS
/**
 * Time Complexity : O(m^2*n^2)
 * Space Complexity : O(m*n)
 * 
 * about time complexity : 
 * 1> O(m*n) for search each node (2 for loop)
 * 2> for DFS, the big-O is O(V+E), well in the matrix, the avg(edge) for each node is 4, and the total nodes are m*n.
 *    so the big-O in this DFS problem is O(m*n)
 */ 
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word==null || word.length()==0)
            return true;
        if(board==null || board.length==0 || board[0].length==0)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(search(board, word, 0, i, j, visited))
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board, String word, int cur, int r, int c, boolean[][] visited) {
        if(cur==word.length())
            return true;
        char tmp = word.charAt(cur);
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c] || board[r][c]!=tmp)
            return false;
        visited[r][c] = true;
        boolean ret = false;
        if(search(board, word, cur+1, r-1, c, visited)
        || search(board, word, cur+1, r+1, c, visited)
        || search(board, word, cur+1, r, c-1, visited)
        || search(board, word, cur+1, r, c+1, visited))
            ret = true;
        visited[r][c] = false;
        return ret;
    }
}


// Solution 2> wrong way !
// BFS
/**
 * 'cause though the char visited on one path cannot be visited on the same path any more, 
 * it could be visited on other ways -- BSF cannot be a good way
 */ 
// class coord {
//     int row;
//     int col;
//     public coord(int r, int c) {
//         row = r;
//         col = c;
//     }
// }
// public class Solution {
//     public boolean exist(char[][] board, String word) {
//         LinkedList<coord> point = new LinkedList<coord>();
//         int cur=0;
//         int next=0;
//         int len = board[0].length;
//         int hei = board.length;
//         for(int i=0; i<hei; i++) {
//             for(int j=0; j<len; j++) {
//                 if(board[i][j]==word.charAt(0)) {
//                     point.offer(new coord(i, j));
//                     cur++;
//                 }
//             }
//         }
//         for(int i=1; i<word.length(); i++) {
//             char goal = word.charAt(i);
//             while(cur>0) {
//                 coord tmpcor = point.poll();
//                 board[tmpcor.row][tmpcor.col] = '*';
//                 cur--;
//                 if(tmpcor.row>0 && board[tmpcor.row-1][tmpcor.col]==goal) {
//                     next++;
//                     point.offer(new coord(tmpcor.row-1, tmpcor.col));
//                 }
//                 if(tmpcor.col>0 && board[tmpcor.row][tmpcor.col-1]==goal) {
//                     next++;
//                     point.offer(new coord(tmpcor.row, tmpcor.col-1));
//                 }
//                 if(tmpcor.row<hei-1 && board[tmpcor.row+1][tmpcor.col]==goal) {
//                     next++;
//                     point.offer(new coord(tmpcor.row+1, tmpcor.col));
//                 }
//                 if(tmpcor.col<len-1 && board[tmpcor.row][tmpcor.col+1]==goal) {
//                     next++;
//                     point.offer(new coord(tmpcor.row, tmpcor.col+1));
//                 }
//             }
//             if(next==0) return false;
//             cur = next;
//             next = 0;
//         }
//         return true;
//     }
// }
