
//----------MEMOIZED AND RECURSSIVE SOLUTION-------------------

// class Solution {
//     public int minFallingPathSum(int[][] matrix) {
//     int m=matrix.length;
//     int n=matrix[0].length; 
//     int dp[][] = new int[m][n];

//     for(int i=0; i<m; i++)
//     for(int j=0; j<n;j++ )
//     {
//         dp[i][j]=-1;
//     }

//     int ans=Integer.MAX_VALUE;
//     for(int i=0; i<n; i++)
//     {
//       ans=Math.min(ans,solve(0,i,m,n,matrix,dp));
//     }

//     return ans;
//     }

//     public int solve(int row,int col,int m,int n,int grid[][],int dp[][])
//     {
        
//         int down=Integer.MAX_VALUE;
//         int rightD=Integer.MAX_VALUE;
//         int leftD=Integer.MAX_VALUE;
//         if(row==m-1)
//         {
//             return grid[row][col];
//         }
//         if(dp[row][col]!=-1)
//         return dp[row][col];

//         if(row<m-1)//can move down
//         down=solve(row+1,col,m,n,grid,dp);

//         if(row<m-1 && col<n-1)//can right diagonal
//         rightD=solve(row+1,col+1,m,n,grid,dp);

//         if(row <m-1 &&col!=0)//can left diagonal
//         leftD=solve(row+1,col-1,m,n,grid,dp);

//         int min=Math.min(down,rightD);


//         return dp[row][col]=grid[row][col]+Math.min(min,leftD);
//     }
// }



//----------Tabulation  SOLUTION-------------------
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        for (int i = 0; i < n; i++)
            dp[m - 1][i] = grid[m - 1][i];

        for (int i = m - 2; i >= 0; i--) {
            int down = Integer.MAX_VALUE;
            int rightD = Integer.MAX_VALUE;
            int leftD = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (i < m - 1)//can move down
                    down = dp[i + 1][j];
                if (i < m - 1 && j < n - 1)//can right diagonal
                    rightD = dp[i + 1][j + 1];
                if (i < m - 1 && j != 0)//can left diagonal
                    leftD = dp[i + 1][j - 1];

                int min = Math.min(down, rightD);
                dp[i][j] = grid[i][j] + Math.min(min, leftD);

            }
        }

        // Return minimum from first row
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[0][j]);
        }
        return result;

    }

}