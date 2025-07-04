class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        for(int i=0; i<n+1;i++)
        {
            dp[i]=-1;
        }
        int ans =solve(n,dp);
        return ans;

    }

    public int solve(int n, int[] dp) {
        dp[0]=1;
        for(int i=1; i<n+1; i++)
        {
        int right = 0;
        int left = dp[i-1];
        if (i > 1)
            right = dp[i - 2];

        dp[i] = left + right;
        }
     return dp[n];
    }
}