class Solution {
    public int cherryPickup(int[][] grid) {

        int rows=grid.length;
        int cols=grid[0].length;
        int dp[][][]= new int[rows][cols][cols];
        for(int i=0; i<rows;i++)
        {
            for(int j=0; j<cols;j++)
            {
                for(int k=0; k<cols;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        int ans=solve(0,0,cols-1,grid,rows,cols,dp);
        return ans;
    }
    public int solve(int i,int j1,int j2,int [][]grid,int rows,int cols,int [][][]dp)
    {
        if(i>rows-1||j1>cols-1||j1<0 ||j2>cols-1||j2<0 )
        return Integer.MIN_VALUE;

        if(i==rows-1)
        {
            if(j1==j2)
            {
                return grid[i][j1];
            }
            else
            {
                return grid[i][j1]+grid[i][j2];
            }
        }

        if(dp[i][j1][j2]!=-1)
        return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;

        for(int dj1=-1; dj1<2;dj1++)
        {
            for(int dj2=-1;dj2<2;dj2++)
            {
            int cherry=0;
             if(j1==j2)
             cherry=grid[i][j1];
             else
             cherry=grid[i][j1]+grid[i][j2];

             cherry=cherry + solve(i+1,j1+dj1,j2+dj2,grid,rows,cols,dp);
             max=Math.max(max,cherry);
            }
        }

        return dp[i][j1][j2]=max;
    }
}