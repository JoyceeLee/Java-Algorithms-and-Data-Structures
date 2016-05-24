/**
* Given a collection of integers that might contain duplicates, S, return all possible subsets.
* 
* Note:
* Elements in a subset must be in non-descending order.
* The solution set must not contain duplicate subsets.
* For example,
* If S = [1,2,2], a solution is:
* 
* [
*   [2],
*   [1],
*   [1,2,2],
*   [2,2],
*   [1,2],
*   []
* ]
* /


public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(num);
        construct(num, 0, cur, ret);
        return ret;
    }
    public void construct(int[] num, int s, List<Integer> cur, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(cur));
        for(int i=s; i<num.length; i++) {
            if(i!=s && num[i]==num[i-1]) {
                continue;
            }
            cur.add(num[i]);
            construct(num, i+1, cur, ret);
            cur.remove(cur.size()-1);
        }
    }
}
