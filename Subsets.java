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
*/


public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(list, tmp, nums, 0);
        return list;
    }
    public void helper(List<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
        list.add(new ArrayList<Integer>(tmp));

        for (int i=start; i<nums.length; i++) {
            tmp.add(nums[i]);
            helper(list, tmp, nums, i+1);
            tmp.remove(tmp.size()-1);
        }
    }
}
