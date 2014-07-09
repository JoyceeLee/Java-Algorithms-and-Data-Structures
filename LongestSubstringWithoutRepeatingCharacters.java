// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
// which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        int j = 0;
        boolean[] appear = new boolean[256];
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(appear[cur]) {
                ret = Math.max(ret, i-j);
                for(int k=j; k<i; k++) {
                    if(s.charAt(k)==cur) {
                        j = k+1;
                        break;
                    } else {
                        appear[s.charAt(k)] = false;
                    }
                }
            } else {
                appear[cur] = true;
            }
        }
        ret = Math.max(ret, s.length()-j);
        return ret;
    }
}
