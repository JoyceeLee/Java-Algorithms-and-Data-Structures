/**
* Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
*
* The same repeated number may be chosen from C unlimited number of times.
* 
* Note:
* All numbers (including target) will be positive integers.
* Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
* The solution set must not contain duplicate combinations.
* For example, given candidate set 2,3,6,7 and target 7,
* A solution set is:
* [7]
* [2, 2, 3]
* /

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(candidates, candidates.length-1, target, cur, ret);
        return ret;
    }
    public void dfs(int[] c, int start, int target, List<Integer> cur, List<List<Integer>> ret) {
        if(target==0) {
            List<Integer> tmp = new ArrayList<Integer>(cur);
            Collections.sort(tmp);
            ret.add(tmp);
            return;
        }
        for(int i=start; i>=0; i--) {
            if(c[i]<=target) {
                cur.add(c[i]);
                dfs(c, i, target-c[i], cur, ret);
                cur.remove(cur.size()-1);
            }
        }
    }
}
