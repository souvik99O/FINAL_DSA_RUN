class Solution {
    public int minPathSum(int[][] grid) {
    int m=grid.length;
    int n=grid[0].length; 
    int dp[][] = new int[m][n];

    for(int i=0; i<m; i++)
    for(int j=0; j<n;j++ )
    {
        dp[i][j]=-1;
    }
    int ans=solve(0,0,m,n,grid,dp);
    return ans;
    }

    public int solve(int row,int col,int m,int n,int grid[][],int dp[][])
    {
        
        int down=Integer.MAX_VALUE;
        int right=Integer.MAX_VALUE;
        
        if(row==m-1 && col==n-1)
        {
            return grid[row][col];
        }
        if(dp[row][col]!=-1)
        return dp[row][col];

        if(row<m-1)//can move down
        down=solve(row+1,col,m,n,grid,dp);

        if(col<n-1)//can move right
        right=solve(row,col+1,m,n,grid,dp);

        return dp[row][col]=grid[row][col]+Math.min(down,right);
    }
}