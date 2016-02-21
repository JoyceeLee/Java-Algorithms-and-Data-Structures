/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * Example:
 * A = [
 *   [ 1, 0, 0],
 *   [-1, 0, 3]
 * ]
 * 
 * B = [
 *   [ 7, 0, 0 ],
 *   [ 0, 0, 0 ],
 *   [ 0, 0, 1 ]
 * ]
 *      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
 * AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
 *      |  0 0 1 |
 */
 
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A.length == 0 || A[0].length == 0 || B[0].length == 0)
            return null;
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[][] ret = new int[m][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (B[i][j] != 0) {
                    if (!map.containsKey(i)) {
                        map.put(i, new ArrayList<Integer>());
                    }
                    map.get(i).add(j);
                }
            }
        }
        List<Integer> tmp = null;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    if (map.containsKey(j)) {
                        tmp = map.get(j);
                        for (int l : tmp) {
                            ret[i][l] += A[i][j] * B[j][l];
                        }
                    }
                }
            }
        return ret;
     }
}
