/**
* Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
* 
* For example, given
* s = "leetcode",
* dict = ["leet", "code"].
* 
* Return true because "leetcode" can be segmented as "leet code".
*/


// Solution 1
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[len] = true;
        for(int i=len-1; i>=0; i--) {
            for(int j=i; j<len; j++) {
                String sub = s.substring(i, j+1);
                if(dict.contains(sub) && dp[j+1]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}


// Solution 2 -- Time Limit Exceed
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(dict.contains(s))
            return true;
            int len = s.length();
        for(int i=1; i<len; i++) {
            String firstPart = s.substring(0,i);
            if(dict.contains(firstPart) == true){
                String remainPart = s.substring(i,length);
                boolean result = wordBreak(remainPart, dict);
                if(result == true){
                    return true;
                }
            }
        }
        return false;
    }
}
