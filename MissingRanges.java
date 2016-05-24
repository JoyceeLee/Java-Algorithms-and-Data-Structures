/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        for (int i : nums) {
            if (lower < i) {
                if (i - lower == 1) {
                    list.add(""+lower);
                } else {
                    list.add(lower+"->"+(i-1));
                }
            }
            lower = i + 1;
        }
        int n = nums.length;
        if (n > 0) {
            if (nums[n-1] < upper) {
                if ( nums[n-1] + 1 < upper) {
                    list.add((nums[n-1]+1)+"->"+upper);
                } else {
                    list.add((nums[n-1]+1)+"");
                }
            }
        } else {
            if (lower == upper) {
                list.add(lower+"");
            } else {
                list.add(lower+"->"+upper);
            }
        }
        return list;
    }
}
