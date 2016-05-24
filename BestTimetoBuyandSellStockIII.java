/**
* Say you have an array for which the ith element is the price of a given stock on day i.
* 
* Design an algorithm to find the maximum profit. You may complete at most two transactions.
* 
* Note:
* You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/


public class Solution {
    public int maxProfit(int[] prices) {
        int[] leftProfit = new int[prices.length];
        int[] rightProfit = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++) {
            if(prices[i]<min) {
                min = prices[i];
            }
            leftProfit[i] = i==0 ? 0 : Math.max(leftProfit[i-1], prices[i]-min);
        }
        int max = Integer.MIN_VALUE;
        for(int i=prices.length-1; i>=0; i--) {
            if(prices[i]>max) {
                max = prices[i];
            }
            rightProfit[i] = i==prices[i].length ? 0 : Math.max(rightProfit[i+1], max-prices[i]);
        }
        int ret = 0;
        for(int i=0; i<prices.length; i++) {
            ret = Math.max(ret, leftProfit[i]+rightProfit[i]);
        }
        return ret;
    }
}
