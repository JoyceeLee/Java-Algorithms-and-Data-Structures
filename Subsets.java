/**
* Given a set of distinct integers, S, return all possible subsets.
* 
* Note:
* Elements in a subset must be in non-descending order.
* The solution set must not contain duplicate subsets.
* For example,
* If S = [1,2,3], a solution is:
* /

/**
* [
*   [3],
*   [1],
*   [2],
*   [1,2,3],
*   [1,3],
*   [2,3],
*   [1,2],
*   []
* ]
* /


public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<Integer> tmp = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        dfs(ret, tmp, S, 0);
        return ret;
    }
    public void dfs(List<List<Integer>> ret, List<Integer> tmp, int[] S, int start) {
        ret.add(new ArrayList<Integer>(tmp));
        for(int i=start; i<S.length; i++) {
            tmp.add(S[i]);
            dfs(ret, tmp, S, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
