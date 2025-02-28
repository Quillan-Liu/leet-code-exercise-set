package org.leetcode_309.solution;

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        int m = prices.length;
        if(m == 1 || m == 0) return 0;
        int[][] dp = new int[m][3];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < m; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i - 1][0] + prices[i];
        }
        return Math.max(dp[m - 1][0], Math.max(dp[m - 1][1], dp[m - 1][2]));
    }
}
