class Solution {
    public int maxProfit(int[] prices) {

        int dp[][][] = new int[prices.length+1][2][2];
        for(int i=0; i<=prices.length;i++)
        for(int j=0; j<2; j++)
        for(int k=0; k<2;k++)
        {
            dp[i][j][k]=-1;
        }
        int ans = solve(0, 1, 0, prices,dp);
        return ans;
    }

    public int solve(int i, int b, int lastSell, int[] prices,int [][][] dp) {
        int n = prices.length;
        if (i >= n)
            return dp[i][b][lastSell]=0;

        if(dp[i][b][lastSell]!=-1)
        return dp[i][b][lastSell];

        int buy = Integer.MIN_VALUE;
        int notBuy = Integer.MIN_VALUE;
        int sell = Integer.MIN_VALUE;
        int notSell = Integer.MIN_VALUE;

        if (b == 1 && lastSell == 0) {
            buy = solve(i + 1, 0, 0, prices,dp) - prices[i];
            notBuy = solve(i + 1, 1, 0, prices,dp);
            return dp[i][b][lastSell]=Math.max(buy, notBuy);
        } else if (b == 1 && lastSell == 1) {
            notBuy = solve(i + 1, 1, 0, prices,dp);
            return dp[i][b][lastSell]=notBuy;

        } else if (b == 0) {
            sell = solve(i + 1, 1, 1, prices,dp) + prices[i];
            notSell = solve(i + 1, 0, 0, prices,dp);
            return dp[i][b][lastSell]=Math.max(sell, notSell);
        }
        return 0;
    }
}