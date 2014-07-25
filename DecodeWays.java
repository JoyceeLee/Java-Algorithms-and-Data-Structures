/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 */


/** 字符串 --> 动态规划
 *  1> 新加进来的数字自己表示一个字符,解析方式有res[i-1]种;
 *  2> 新加进来的数字和前一个数字凑成一个字符，解析的方式有res[i-2]种
 */
 

/**
 * Solution 1>
 * Time Complecity : O(n)
 * Space Complexity : O(n)
 */
public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        int len = s.length();
        int[] ways = new int[len+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i=1; i<len; i++) {
            if(s.charAt(i)=='0') {
                if(s.charAt(i-1)!='1' && s.charAt(i-1)!='2') {
                    return 0;
                } else {
                    ways[i+1] = ways[i-1];
                }
            } else {
                ways[i+1] = ways[i];
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')) {
                    ways[i+1] += ways[i-1];
                }
            }
        }
        return ways[len];
    }
}


/**
 * Solution 1>
 * Time Complecity : O(n)
 * Space Complexity : O(1)
 */
public class Solution {
    public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        int len = s.length();
        int[] ways = new int[len+1];
        int prePre = 1;
        int pre = 1;
        int res = 1;
        for(int i=1; i<len; i++) {
            if(s.charAt(i)=='0') {
                if(s.charAt(i-1)!='1' && s.charAt(i-1)!='2') {
                    return 0;
                } else {
                    res = prePre;
                }
            } else {
                res = pre;
                if(s.charAt(i-1)=='1' || (s.charAt(i-1)=='2' && s.charAt(i)<='6')) {
                    res += prePre;
                }
            }
            prePre = pre;
            pre = res;
        }
        return res;
    }
}
