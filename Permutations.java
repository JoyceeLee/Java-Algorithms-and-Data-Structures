// Given a collection of numbers, return all possible permutations.

/**
* For example,
* [1,2,3] have the following permutations:
* [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

public class Solution {
    public List<List<Integer>> permute(int[] num) {
      List<List<Integer>> ret = new ArrayList<List<Integer>>();
      List<Integer> cur = new ArrayList<Integer>();
      buildPerm(num, cur, ret);
      return ret;
    }
    public void buildPerm(int[] num, List<Integer> cur, List<List<Integer>> ret) {
      if(num.length==0) {
        ret.add(new ArrayList<Integer>(cur));
        return;
      }
      for(int i=0; i<num.length; i++) {
        int[] remNum = new int[num.length-1];
        System.arraycopy(num, 0, remNum, 0, i);
        System.arraycopy(num, i+1, remNum, i, num.length-1-i);
        cur.add(num[i]);
        buildPerm(remNum, cur, ret);
        cur.remove(cur.size()-1);
      }
    }
}
