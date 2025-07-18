class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 1, 0, prices, dp);
    }

    public int solve(int i, int canBuy, int lastSell, int[] prices, int[][][] dp) {
        int n = prices.length;
        if (i >= n) return 0; // No future profit possible

        if (dp[i][canBuy][lastSell] != -1) return dp[i][canBuy][lastSell];

        int profit;
        if (canBuy == 1 && lastSell == 0) {
            int buy = solve(i + 1, 0, 0, prices, dp) - prices[i];
            int notBuy = solve(i + 1, 1, 0, prices, dp);
            profit = Math.max(buy, notBuy);
        } else if (canBuy == 1 && lastSell == 1) {
            // Cooldown day → can only skip
            profit = solve(i + 1, 1, 0, prices, dp);
        } else {
            // Holding → sell or hold
            int sell = solve(i + 1, 1, 1, prices, dp) + prices[i];
            int notSell = solve(i + 1, 0, 0, prices, dp);
            profit = Math.max(sell, notSell);
        }

        dp[i][canBuy][lastSell] = profit;
        return profit;
    }
}
