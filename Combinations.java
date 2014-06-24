/**
* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
* 
* For example,
* If n = 4 and k = 2, a solution is:
* 
* [
*   [2,4],
*   [3,4],
*   [2,3],
*   [1,2],
*   [1,3],
*   [1,4],
* ]
* /


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        int next = 1;
        combination(ret, cur, n, k, next);
        return ret;
    }
    public void combination(List<List<Integer>> ret, List<Integer> cur, int n, int k, int next) {
        if(cur.size()==k) {
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=next; i<=n; i++) {
            cur.add(i);
            combination(ret, cur, n, k, i+1);
            cur.remove(cur.size()-1);
        }
        return;
    }
}
