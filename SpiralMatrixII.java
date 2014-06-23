// Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.

// For example, Given n = 3,

// You should return the following matrix:
/**
* [
*  [ 1, 2, 3 ],
*  [ 8, 9, 4 ],
*  [ 7, 6, 5 ]
* ]
* /

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int start = 0;
        int end = n-1;
        int num = 1;
        while(start<end) {
            for(int i=start; i<end; i++) {
                matrix[start][i] = num++;
            }
            for(int i=start; i<end; i++) {
                matrix[i][end] = num++;
            }
            for(int i=end; i>start; i--) {
                matrix[end][i] = num++;
            }
            for(int i=end; i>start; i--) {
                matrix[i][start] = num++;
            }
            start++;
            end--;
        }
        if(start==end) {
            matrix[start][end] = num;
        }
        return matrix;
    }
}
