class Solution {
    public int uniquePaths(int m, int n) {

    int dp[][]=new int[m][n];
    for(int i=0; i<m; i++)
    {
        for(int j=0; j<n; j++)
        {
            dp[i][j]=-1;
        }
    }    
    int ans= solve(0,0,m,n,dp);
    return ans;
    }
    public int solve(int row , int col,int m, int n,int dp[][])
    {
        int down=0;
        int right=0;
        if(row>=m || col>=n)
        return 0;
        if(row==m-1 && col==n-1)
        return 1;

        if(dp[row][col]!=-1)
        return dp[row][col];


        if(row!=m-1)
        down=solve(row+1,col,m,n,dp);
        if(col!=n-1)
        right=solve(row,col+1,m,n,dp);

        return dp[row][col]=down+right;
    }
}