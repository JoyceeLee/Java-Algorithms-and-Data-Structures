/**
* Given a collection of candidate numbers (C) and a target number (T), 
* find all unique combinations in C where the candidate numbers sums to T.
* 
* Each number in C may only be used once in the combination.
* 
* Note:
* All numbers (including target) will be positive integers.
* Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
* The solution set must not contain duplicate combinations.
* For example, given candidate set 10,1,2,7,6,1,5 and target 8,
* A solution set is:
* [1, 7]
* [1, 2, 5]
* [2, 6]
* [1, 1, 6]
* /


public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(num);
        combine(ret, cur, num, target, 0);
        return ret;
    }
    public void combine(List<List<Integer>> ret, List<Integer> cur, int[] num, int target, int s) {
        if(target==0) {
            if(!ret.contains(cur)) {
                ret.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        for(int i = s; i<num.length; i++) {
            if(target>=num[i]) {
                cur.add(num[i]);
                combine(ret, cur, num, target-num[i], i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
}
