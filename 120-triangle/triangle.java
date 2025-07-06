class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.size()];
        for(int i=0; i<triangle.size();i++)
        for(int j=0; j<triangle.size();j++)
        {
            dp[i][j]=-1;
        }
        int ans=solve(0,0,triangle,dp);
        return ans;
    }

    public int solve(int row,int col, List<List<Integer>>list,int dp[][])
    {
        
       //base case
       if(row>=list.size())
       {
        return 0;
       }

        if(dp[row][col]!=-1)
        return dp[row][col];

       int left=solve(row+1,col,list,dp);
       int right=solve(row+1,col+1,list,dp);

        return dp[row][col]=list.get(row).get(col)+Math.min(left,right);
    }
}
