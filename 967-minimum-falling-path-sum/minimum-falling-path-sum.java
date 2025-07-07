class Solution {
    public int minFallingPathSum(int[][] grid) {
    int m=grid.length;
    int n=grid[0].length; 
    int dp[][] = new int[m][n];

    
    
       
        for(int i=0; i<n; i++)  
        dp[m-1][i]=grid[m-1][i];

        
        for(int i=m-2; i>=0;i--)
        {
        int down=Integer.MAX_VALUE;
        int rightD=Integer.MAX_VALUE;
        int leftD=Integer.MAX_VALUE;
        
            for(int j=0; j<n; j++)
            {
                 if(i<m-1)//can move down
                 down=dp[i+1][j];
                 if(i<m-1 && j<n-1)//can right diagonal
                 rightD=dp[i+1][j+1];
                 if(i <m-1 &&j!=0)//can left diagonal
                 leftD=dp[i+1][j-1];

                 int min=Math.min(down,rightD);
                 dp[i][j]=grid[i][j]+Math.min(min,leftD);

            }
        }

             // Return minimum from first row
        int result = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            result = Math.min(result, dp[0][j]);
        }
        return result; 
 
    }

}