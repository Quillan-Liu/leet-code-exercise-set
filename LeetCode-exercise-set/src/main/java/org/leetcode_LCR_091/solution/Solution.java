package org.leetcode_LCR_091.solution;

class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length <= 0) {
            return 0;
        }
        int m = costs.length;
        int[][] dp = new int[m][3];
        for(int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[m - 1][0], Math.min(dp[m - 1][1], dp[m - 1][2]));
    }
}
