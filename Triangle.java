/**
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
* 
* For example, given the following triangle
* [
*      [2],
*     [3,4],
*    [6,5,7],
*   [4,1,8,3]
* ]
* The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
* 
* Note:
* Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
* /


public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] pathSum = new int[row];
        for(int i=row-1; i>-1; i--) {
            int col = triangle.get(i).size();
            for(int j=0; j<col; j++) {
                if(i==row-1) {
                    pathSum[j] = triangle.get(i).get(j);
                } else {
                    pathSum[j] = triangle.get(i).get(j)+Math.min(pathSum[j], pathSum[j+1]);
                }
            }
        }
        return pathSum[0];
    }
}
