/**
* Given numRows, generate the first numRows of Pascal's triangle.
* 
* For example, given numRows = 5,
* Return
* 
* [
*      [1],
*     [1,1],
*    [1,2,1],
*   [1,3,3,1],
*  [1,4,6,4,1]
* ]
* /


public class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      for(int r = 0; r<numRows; r++) {
        ArrayList<Integer> tmp = new ArrayList<Integer>(r+1);
        for(int c = 0; c<=r; c++) {
          if(c == 0 || c == r) {tmp.add(1);}
          else {
            tmp.add(pt.get(r-1).get(c-1)+pt.get(r-1).get(c));
          }
        }
        pt.add(tmp);
      }
      return pt;
    }
}
