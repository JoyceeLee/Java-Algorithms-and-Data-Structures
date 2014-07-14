/**
* Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
* 
* For example,
* Given the following matrix:
* 
* [
*  [ 1, 2, 3 ],
*  [ 4, 5, 6 ],
*  [ 7, 8, 9 ]
* ]
* You should return [1,2,3,6,9,8,7,4,5].
* /


public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(matrix.length==0 || matrix[0].length==0)
            return ret;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = 0;
        while(m>0 && n>0) {
            if(n==1) {
                for(int i=0; i<m; i++) {
                    ret.add(matrix[x++][y]);
                }
                break;
            } else if(m==1) {
                for(int i=0; i<n; i++) {
                    ret.add(matrix[x][y++]);
                }
                break;
            }
            for(int i=0; i<n-1; i++) {
                ret.add(matrix[x][y++]);
            }
            for(int i=0; i<m-1; i++) {
                ret.add(matrix[x++][y]);
            }
            for(int i=0; i<n-1; i++) {
                ret.add(matrix[x][y--]);
            }
            for(int i=0; i<m-1; i++) {
                ret.add(matrix[x--][y]);
            }
            x++;
            y++;
            n = n-2;
            m = m-2;
        }
        return ret;
    }
}
