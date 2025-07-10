class Solution {
    public int change( int amount, int[] coins) {
        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(0, amount, coins,dp);
        return  ans;
    }

    public int solve(int ind, int amt, int coins[],int [][]dp) {
        int n = coins.length;
        if (ind >= n) {
            return 0;
        }
        if (amt == 0) {
            return 1;
        }
        if (dp[ind][amt] != -1)
            return dp[ind][amt];

        int pick = 0;
        if (coins[ind] <= amt) {
            pick=solve(ind,amt-coins[ind],coins,dp);
          
        }
        int notPick = solve(ind + 1, amt, coins,dp);

        return dp[ind][amt] = pick+notPick;

    }
}