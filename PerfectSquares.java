/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
*/

// DP solution
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            // double to int, convert
            int sqrt = (int) Math.sqrt(i);
            if (i == sqrt * sqrt) {
                dp[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++)
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
        return dp[n];
    }
}

// Static DP solution
public class Solution {
    // 1. static key word
    // 2. ArrayList--get time is O(1); LinkedList--get time is O(n)
    public static List<Integer> dp = new ArrayList<Integer>();
    
    public int numSquares(int n) {
        if (dp.size() == 0) dp.add(0);
        
        while (dp.size() <= n) {
            int cur = dp.size();
            int tmp = Integer.MAX_VALUE;
            for (int j = 1; j * j <= cur; j++)
                tmp = Math.min(tmp, dp.get(cur - j * j) + 1);
            dp.add(tmp);
        }
        return dp.get(n);
    }
}
