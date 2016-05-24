/**
* Given a string S, find the longest palindromic substring in S. 
* You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
*/

/**
 * Solution 1 DP
 * Time -- n^2
 * Space - n^2
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;
        int n = s.length();
        boolean[][] map = new boolean[n][n];
        int longest = 1;
        int start = 0;
        int end = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i  || (j - i < 3 && s.charAt(i) == s.charAt(j))) {
                    map[i][j] = true;
                } else {
                    map[i][j] = (j - i > 1 && map[i + 1][j - 1] && s.charAt(i) == s.charAt(j));
                }
                if (map[i][j] && j - i + 1  > longest) {
                    longest = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}

/**
 * Solution 2 
 * Time -- n ~ n^2, many useless test could be avoid
 * Space - constant
 */
 class Pair {
	int start;
	int end;
	public int dist() {
		return end-start;
	}
	public void set(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public void set(Pair a) {
		this.start = a.start;
		this.end = a.end;
	}
}
public class Solution {
    public String longestPalindrome(String s) {
    	if(s == null || s.length() < 2) {
    		return s;
    	}
    	int len = s.length();
    	Pair tmp = new Pair();
    	Pair max = new Pair();
    	max.set(0, 1);
    	for(int i = 0; i < len; i++) {
    		tmp = helper(s, i, i);
    		if(max.dist() < tmp.dist()) {
    			max.set(tmp);
    		}
    	}
    	for(int i = 0; i < len-1; i++) {
    		tmp = helper(s, i, i+1);
    		if(max.dist() < tmp.dist()) {
    			max.set(tmp);
    		}
    	}
        return s.substring(max.start, max.end);
    }
    public Pair helper(String s, int idx0, int idx1) {
        while(idx0 >= 0 && idx1 < s.length() && s.charAt(idx0) == s.charAt(idx1)) {
            idx0--;
            idx1++;
        }
        Pair p = new Pair();
        p.set(idx0+1, idx1);
        return p;
    }
}
 
