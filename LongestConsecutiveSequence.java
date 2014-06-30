/**
* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
* 
* For example,
* Given [100, 4, 200, 1, 3, 2],
* The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
* 
* Your algorithm should run in O(n) complexity.
* /


public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> ret = new HashSet<Integer>();
        for(int i=0; i<num.length; i++) {
            ret.add(num[i]);
        }
        int maxLength = 0;
        for(Integer e : ret) {
            int curLength = 1;
            ret.remove(e);
            int left = e-1;
            int right = e+1;
            while(ret.contains(left)) {
                curLength++;
                ret.remove(left);
                left--;
            }
            while(ret.contains(right)) {
                curLength++;
                ret.remove(right);
                right++;
            }
            maxLength = Math.max(maxLength, curLength);
        }
        return maxLength;
    }
}
