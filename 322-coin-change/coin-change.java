class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(0, amount, coins,dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int ind, int amt, int coins[],int [][]dp) {
        int n = coins.length;
        if (ind >= n) {
            return Integer.MAX_VALUE;
        }
        if (amt == 0) {
            return 0;
        }
        if (dp[ind][amt] != -1)
            return dp[ind][amt];

        int pick = Integer.MAX_VALUE;
        if (coins[ind] <= amt) {
            // pick=1+solve(ind,amt-coins[ind],coins);
            int result = solve(ind, amt - coins[ind], coins,dp);
            if (result != Integer.MAX_VALUE)
                pick = 1 + result;
        }
        int notPick = solve(ind + 1, amt, coins,dp);

        return dp[ind][amt] = Math.min(pick, notPick);

    }
}